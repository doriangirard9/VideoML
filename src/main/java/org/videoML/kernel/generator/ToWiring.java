package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.video.*;
import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.effects.video.*;

public class ToWiring extends Visitor<StringBuffer> {
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
        w("# Code generated from a VideoML scrip\n");
        w(String.format("# Video name: %s\n", video.getName()) + "\n");

        w("from moviepy import *\n\n");

        w("font = \"./font/font.ttf\"\n\n");

        w(String.format("video_width = %d\n", video.getWidth()));
        w(String.format("video_height = %d\n\n", video.getHeight()));

        for (String listName : video.getCombineClipList()) {
            w(String.format("%s_list = []\n", listName));
        }

        for (Clip clip : video.getTimeline()) {
            clip.accept(this);
        }

        if (!video.isPreview()) {
            w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", Video.getFinalClipName(), Video.getFinalClipName()));
            w(String.format("%s.write_videofile(\"%s.mp4\", codec=\"libx264\", fps=%d)\n",
                    Video.getFinalClipName(), video.getName(), video.getFps()));
        }
    }

    @Override
    public void visit(VideoClip videoClip) {
        String startTime = (videoClip.getStartTime() != null) ? videoClip.getStartTime() : currentStart;
        w(String.format("%s = %s.with_start(%s)\n",
            videoClip.getName(), videoClip.getSource(), startTime));
        w(String.format("%s = %s.with_position(('%s', '%s'))\n",
            videoClip.getName(), videoClip.getName(), videoClip.getPositionX(), videoClip.getPositionY()));

        for (Effect effect : videoClip.getEffects()) {
            effect.accept(this);
        }

        w(String.format("%s_list.append(%s)\n", videoClip.getParent(), videoClip.getName()));
        currentStart = String.format("%s.end", videoClip.getName());
    }

    @Override
    public void visit(CutVideoClip cutVideoClip) {
        String startTime = (cutVideoClip.getStartTime() != null) ? cutVideoClip.getStartTime() : currentStart;
        w(String.format("%s = %s.subclipped(%s, %s).with_start(%s)\n",
                cutVideoClip.getName(), cutVideoClip.getSource(),
                cutVideoClip.getStart().replace("s", ""),
                cutVideoClip.getEnd().replace("s", ""),
                startTime));
        w(String.format("%s = %s.with_position(('%s', '%s'))\n",
                cutVideoClip.getName(), cutVideoClip.getName(), cutVideoClip.getPositionX(), cutVideoClip.getPositionY()));
        
        for (Effect effect : cutVideoClip.getEffects()) {
            effect.accept(this);
        }

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

        for (Effect effect : textClip.getEffects()) {
            effect.accept(this);
        }

        w(String.format("%s_list.append(%s)\n", textClip.getParent(), textClip.getName()));
    }

    @Override
    public void visit(ImageClip imageClip) {
        String duration = String.format("%d", imageClip.getDuration());
        String startTime = currentStart;

        if (imageClip.getTargetClip() != null) {
            startTime = String.format("%s.start + %d", imageClip.getTargetClip(), imageClip.getDelay()); ;

            // if duration is unset the image will sync with the target clip
            if (imageClip.getDuration() == 0)
                duration = String.format("%s.start + %s.end - %d", 
                    imageClip.getTargetClip(), imageClip.getTargetClip(), imageClip.getDelay());
        }

        w(String.format("%s = ImageClip(\"%s\")"
                + ".with_position('center')"
                + ".with_start(%s)"
                + ".with_duration(%s)\n",
                imageClip.getName(), imageClip.getSource(), startTime, duration));

        // Only update currentStart when imageClip is standalone        
        if (imageClip.getTargetClip() == null) {
            currentStart = String.format("%s.end", imageClip.getName());
        }

        for (Effect effect : imageClip.getEffects()) {
            effect.accept(this);
        }

        w(String.format("%s_list.append(%s)\n", imageClip.getParent(), imageClip.getName()));
    }

    @Override
    public void visit(CompositeVideoClip compositeVideoClip) {
        w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", 
            compositeVideoClip.getName(),
            compositeVideoClip.getName()));
        w(String.format("%s = %s.with_position(('%s', '%s'))\n",
            compositeVideoClip.getName(), compositeVideoClip.getName(), compositeVideoClip.getPositionX(), compositeVideoClip.getPositionY()));

        for (Effect effect : compositeVideoClip.getEffects()) {
            effect.accept(this);
        }

        w(String.format("%s_list.append(%s)\n", compositeVideoClip.getParent(), compositeVideoClip.getName()));
        currentStart = String.format("%s.end", compositeVideoClip.getName());
    }

    @Override
    public void visit(PreviewClip previewClip) {
        String name = "";
        if (previewClip.getName() != null) {
            name = previewClip.getName();
        } else {
            name = Video.getFinalClipName();
            w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", Video.getFinalClipName(), Video.getFinalClipName()));
        }
        w(String.format("%s.preview(fps=%s)\n", name, this.video.getFps()));
    }

    @Override
    public void visit(Resize resize) {
        String targetClip = resize.getClipName();

        if (resize.isScale) {
            w(String.format("%s = %s.resized(%s)\n",
                    targetClip, targetClip, String.valueOf(resize.getScale()).replace(",", ".")));
        }
        else {
            w(String.format("%s = %s.resized(width=%d, height=%d)\n",
                    targetClip, targetClip, resize.getWidth(), resize.getHeight()));
        }
    }
    
    @Override
    public void visit(Transition transition) {
        String transitionEffect = "";

        if (transition.getType() == TransitionType.FADEIN)
            transitionEffect = String.format("vfx.FadeIn(%s)", transition.getDuration());
        else if (transition.getType() == TransitionType.FADEOUT)
            transitionEffect = String.format("vfx.FadeOut(%s)", transition.getDuration());
        else if (transition.getType() == TransitionType.CROSSFADEIN)
            transitionEffect = String.format("vfx.CrossFadeIn(%s)", transition.getDuration());
        else if (transition.getType() == TransitionType.CROSSFADEOUT)
            transitionEffect = String.format("vfx.CrossFadeOut(%s)", transition.getDuration());

        w(String.format("%s = %s.with_effects([%s])\n", 
            transition.getClipName(), transition.getClipName(), transitionEffect));
    }

    @Override
    public void visit(Rotate rotate) {
        String targetClip = rotate.getClipName();

        w(String.format("%s = %s.with_effects([vfx.Rotate(%d)])\n",
                targetClip, targetClip, rotate.getAngle()));
    }

    @Override
    public void visit(SpeedChanger speedChanger) {
        String targetClip = speedChanger.getClipName();

        w(String.format("%s = %s.with_effects([vfx.MultiplySpeed(%s)])\n",
                targetClip, targetClip, speedChanger.getFactor()));
    }

    @Override
    public void visit(Freeze freeze) {
        String targetClip = freeze.getClipName();
        String freezeEffect = String.format("vfx.Freeze(%s, %s)", freeze.getTimer(), freeze.getDuration());

        w(String.format("%s = %s.with_effects([%s])\n",
                targetClip, targetClip, freezeEffect));
    }

    @Override
    public void visit(Crop crop) {
        String targetClip = crop.getClipName();
        String x1 = String.format("(%s.w * %d) / 100", targetClip, crop.getX1());
        String y1 = String.format("(%s.h * %d) / 100", targetClip, crop.getY1());
        String x2 = String.format("%s.w - ((%s.w * %d) / 100)", targetClip, targetClip, crop.getX2());
        String y2 = String.format("%s.h - ((%s.h * %d) / 100)", targetClip, targetClip, crop.getY2());
        String cropEffect = String.format("vfx.Crop(x1=%s, y1=%s, x2=%s, y2=%s)", x1, y1, x2, y2);

        w(String.format("%s = %s.with_effects([%s])\n",
                targetClip, targetClip, cropEffect));
    }

    @Override
    public void visit(GreenScreen greenScreen) {
        String targetClip = greenScreen.getClipName();
        String greenScreenEffect = String.format(
                "vfx.MaskColor(color=(0, 255, 8), threshold=%d, stiffness=5)", greenScreen.getThreshold());

        w(String.format("%s = %s.with_effects([%s])\n",
                targetClip, targetClip, greenScreenEffect));
    }
}