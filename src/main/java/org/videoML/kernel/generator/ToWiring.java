package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.Transition;
import org.videoML.kernel.clips.video.CompositeVideoClip;
import org.videoML.kernel.clips.video.CutVideoClip;
import org.videoML.kernel.clips.video.TextClip;
import org.videoML.kernel.clips.video.VideoClip;
import org.videoML.kernel.effects.Blur;
import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.effects.Freeze;
import org.videoML.kernel.effects.Resize;


public class ToWiring extends Visitor<StringBuffer> {
    private String currentStart = "0";

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    @Override
    public void visit(Video video) {
        w("# Code generated from a VideoML scrip\n");
        w(String.format("# Video name: %s\n", video.getName()) + "\n");

        w("from moviepy import *\n\n");

        w("font = \"./font/font.ttf\"\n\n");

        w("video_width = 1280\n");
        w("video_height = 720\n\n");

        for (String listName : video.getCombineClipList()) {
            w(String.format("%s_list = []\n", listName));
        }

        for (Clip clip : video.getTimeline()) {
            clip.accept(this);
        }

        w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", Video.getFinalClipName(), Video.getFinalClipName()));
        w(String.format("%s.write_videofile(\"output.mp4\", codec=\"libx264\")\n", Video.getFinalClipName()));
    }

    @Override
    public void visit(VideoClip videoClip) {
        String startTime = (videoClip.getStartTime() != null) ? videoClip.getStartTime() : currentStart;
        w(String.format("%s = %s.with_start(%s)\n",
            videoClip.getName(), videoClip.getSource(), startTime));

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

        w(String.format("%s_list.append(%s)\n", videoClip.getName(), videoClip.getParent()));
        currentStart = String.format("%s.end", videoClip.getName(), videoClip.getParent());
    }

    @Override
    public void visit(CutVideoClip cutVideoClip) {
        String startTime = (cutVideoClip.getStartTime() != null) ? cutVideoClip.getStartTime() : currentStart;
        w(String.format("%s = %s.subclipped(%s, %s).with_start(%s)\n",
                cutVideoClip.getName(), cutVideoClip.getSource(),
                cutVideoClip.getStart().replace("s", ""),
                cutVideoClip.getEnd().replace("s", ""),
                startTime));
        
        w(String.format("%s_list.append(%s)\n", cutVideoClip.getParent(), cutVideoClip.getName()));
        currentStart = String.format("%s.end", cutVideoClip.getName());
    }

    @Override
    public void visit(TextClip textClip) {
        String duration = String.format("%d", textClip.getDuration());
        String startTime = currentStart;

        if (textClip.getTargetClip() != null) {
            startTime = String.format("%s.start + %d", textClip.getTargetClip(), textClip.getDelay()); ;

            // if duration is unset the text will sync with the target clip
            if (textClip.getDuration() == 0)
                duration = String.format("%s.start + %s.end - %d", textClip.getTargetClip(), textClip.getTargetClip(), textClip.getDelay());
        }

        w(String.format("%s = TextClip(text=\"%s\", font=font, font_size=48, color='white')"
                + ".with_position('center')"
                + ".with_start(%s)"
                + ".with_duration(%s)\n",
                textClip.getName(), textClip.getText(), startTime, duration));

        // Only update currentStart when textClip is standalone        
        if (textClip.getTargetClip() == null) {
            currentStart = String.format("%s.end", textClip.getName());
        }

        w(String.format("%s_list.append(%s)\n", textClip.getParent(), textClip.getName()));
    }

    @Override
    public void visit(CompositeVideoClip compositeVideoClip) {
        w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", 
            compositeVideoClip.getName(),
            compositeVideoClip.getName()));

        w(String.format("%s_list.append(%s)\n", compositeVideoClip.getParent(), compositeVideoClip.getName()));
        currentStart = String.format("%s.end", compositeVideoClip.getName());
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
        }
    }

    @Override
    public void visit(Blur blur) {
        // TODO NOT YET IMPLEMENTED
        return;
    }

    @Override
    public void visit(Resize resize) {
        System.out.println("VISITING RESIZE EFFECT");
        String targetClip = resize.getClipName();

        if(resize.isScale){
            w(String.format("%s = %s.resized(%f)\n",
                    targetClip, targetClip, resize.getScale()));
        }
        else {
            w(String.format("%s = %s.resized(width=%d, height=%d)\n",
                    targetClip, targetClip, resize.getWidth(), resize.getHeight()));
        }
    }
}