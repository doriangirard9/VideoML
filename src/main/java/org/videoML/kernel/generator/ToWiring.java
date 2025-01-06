package org.videoML.kernel.generator;

import org.videoML.kernel.TimelineElement;
import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.CutClip;
import org.videoML.kernel.clips.Transition;
import org.videoML.kernel.clips.VideoClip;
import org.videoML.kernel.Caption;
import org.videoML.kernel.effects.Blur;
import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.effects.Freeze;
import org.videoML.kernel.effects.Resize;

import java.util.Optional;


public class ToWiring extends Visitor<StringBuffer> {
    private int captionIndex = 1;
    private String currentStart = "0";
    private Video video;

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    @Override
    public void visit(Video video) {
        this.video = video;
        w("# Code generated from a VideoML script\n");
        w(String.format("# Video name: %s\n", video.getName()) + "\n");

        w("from moviepy import *\n\n");

        w("font = \"./font/font.ttf\"\n\n");

        w("video_width = 1280\n");
        w("video_height = 720\n\n");

        w("final_clips = []\n");

        for (TimelineElement element : video.getTimeline()) {
            if (element instanceof Caption) {
                this.visit((Caption) element);
            } else if (element instanceof VideoClip) {
                this.visit((VideoClip) element);
            } else if (element instanceof CutClip) {
                this.visit((CutClip) element);
            }
        }

        w("final_clip = CompositeVideoClip(final_clips, size=(video_width, video_height))\n");
        w("final_clip.write_videofile(\"output.mp4\", codec=\"libx264\")\n");
    }

    @Override
    public void visit(VideoClip videoClip) {
        String startTime = (videoClip.getStartTime() != null) ? videoClip.getStartTime() : currentStart;
        w(String.format("%s = VideoFileClip(\"%s\").with_start(%s)\n",
            videoClip.getName(), videoClip.getPath(), startTime));

        for (Transition transition : videoClip.getTransitions()) {
            this.visit(transition);
        }


        for(Effect effect: videoClip.getEffects()){
            switch(effect.getEffectName()){
                case "freeze":
                    Freeze freeze = (Freeze) effect;
                    this.visit(freeze);
                    break;
                case "blur":
                    Blur blur = (Blur) effect;
                    this.visit(blur);
                    break;
                case "resize":
                    Resize resize = (Resize) effect;
                    this.visit(resize);
                default:
                    System.err.println("Unsupported effect: " + effect.getEffectName());
                    System.exit(1);
            }
        }

        w(String.format("final_clips.append(%s)\n", videoClip.getName()));
        currentStart = String.format("%s.end", videoClip.getName());
    }

    @Override
    public void visit(CutClip clipCut) {
        w(String.format("%s = VideoFileClip(\"%s\").subclipped(%s, %s).with_start(%s)\n",
                clipCut.getName(), clipCut.getSourcePath(),
                clipCut.getStartTime().replace("s", ""),
                clipCut.getEndTime().replace("s", ""),
                currentStart));

        for (Transition transition : clipCut.getTransitions()) {
            this.visit(transition);
        }

        for(Effect effect: clipCut.getEffects()){
            switch(effect.getEffectName()){
                case "freeze":
                    Freeze freeze = (Freeze) effect;
                    this.visit(freeze);
                    break;
                case "blur":
                    Blur blur = (Blur) effect;
                    this.visit(blur);
                    break;
            }
        }


        w(String.format("final_clips.append(%s)\n", clipCut.getName()));
        currentStart = String.format("%s.end", clipCut.getName());
    }

    @Override
    public void visit(Caption caption) {
        String startExpression;

        if (caption.getClipName() == null) {
            // Standalone caption
            startExpression = currentStart;
        } else if (caption.getRelativeReference() != null) {
            // Relative reference
            String referenceClip = caption.getRelativeReference();
            String startTime;
            if (caption.getOffset() > 0) {
                startTime = getClipEndTime(referenceClip, video) + " + " + caption.getOffset();
            } else {
                startTime = getClipStartTime(referenceClip, video) + caption.getOffset();
            }
            startExpression = String.format("%s + %d", startTime, caption.getStartTime());
        } else {
            // Tied to a clip
            startExpression = String.format("%s.start + %d", caption.getClipName(), caption.getStartTime());
        }

        w(String.format(
                "caption%d = (TextClip(text=\"%s\", font=font, font_size=48, color='white')"
                        + ".with_duration(%d)"
                        + ".with_position('center')"
                        + ".with_start(%s))\n",
                captionIndex, caption.getText(), caption.getDuration(), startExpression
        ));
        w(String.format("final_clips.append(caption%d)\n", captionIndex));

        // Only update currentStart when caption is standalone
        if (caption.getClipName() == null && caption.getRelativeReference() == null) {
            currentStart = String.format("caption%d.end", captionIndex);
        }
        captionIndex++;
    }

    @Override
    public void visit(Transition transition) {
        String transitionEffect = "";
        switch (transition.getType()) {
            case FADEIN:
                transitionEffect = String.format("vfx.FadeIn(%s)", transition.getDuration());
                break;
            case FADEOUT:
                transitionEffect = String.format("vfx.FadeOut(%s)", transition.getDuration());
                break;
            default:
                throw new IllegalArgumentException("Unsupported transition type: " + transition.getType());
        }

        String targetClip = transition.getTargetClip();
        if (targetClip != null) {
            w(String.format("%s = %s.with_effects([%s])\n",
                    targetClip, targetClip, transitionEffect));
        }
    }

    @Override
    public void visit(Freeze freeze) {
        String targetClip = freeze.getClipName();
        String freezeEffect = String.format("vfx.Freeze(%s, %s)", freeze.getTimer(), freeze.getDuration());

        if(targetClip != null) {
            w(String.format("%s = %s.with_effects([%s])\n",
                    targetClip, targetClip, freezeEffect));
            // We need to re-set the start/end timers after applying an effect

            resetStartTime(targetClip);
        }
    }

    @Override
    public void visit(Blur blur) {
        // TODO NOT YET IMPLEMENTED
        return;
    }

    @Override
    public void visit(Resize resize) {
        String targetClip = resize.getClipName();

        if(resize.isScale){
            w(String.format("%s = %s.resize(%f)\n",
                    targetClip, targetClip, resize.getScale()));
        }
        else {
            w(String.format("%s = %s.resize((width=%d, height=%d))\n",
                    targetClip, targetClip, resize.getWidth(), resize.getHeight()));
        }

        resetStartTime(targetClip);
    }

    private String getClipTime(String clipName, Video video, boolean isStartTime) {
        int captionIndex = 1;
        for (TimelineElement element : video.getTimeline()) {
            if (element instanceof Clip) {
                if (element.getName().equals(clipName)) {
                    return element.getName() + (isStartTime ? ".start" : ".end");
                }
            } else if (element instanceof Caption) {
                Caption caption = (Caption) element;
                if (clipName.contains(caption.getText())) {
                    return String.format("caption%d.%s", captionIndex, isStartTime ? "start" : "end");
                }
                captionIndex++;
            }
        }
        return null;
    }

    private String getClipStartTime(String clipName, Video video) {
        return getClipTime(clipName, video, true);
    }

    private String getClipStartTime(String clipName){
        // We get the clip from the Video object
        Optional<Clip> clip = video.getTimeline().stream()
                .filter(e -> (e instanceof VideoClip || e instanceof CutClip) && (e.getName().equals(clipName)))
                .map(e -> (Clip) e)
                .findFirst();

        if(clip.isPresent()){
            return clip.get().getStartTime();
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    private String getClipEndTime(String clipName, Video video) {
        return getClipTime(clipName, video, false);
    }

    public void resetStartTime(String targetClip){
        String startTime = getClipStartTime(targetClip);
        if(startTime == null)
            startTime = currentStart;

        w(String.format("%s = %s.with_start(%s).with_end(%s.end)\n",
                targetClip, targetClip, startTime.replace("s", ""), targetClip));
    }
}