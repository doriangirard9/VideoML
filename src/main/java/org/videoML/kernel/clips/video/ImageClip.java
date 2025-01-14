package org.videoML.kernel.clips.video;

import org.videoML.kernel.generator.Visitor;

public class ImageClip extends VideoClip {
    private int duration = 0;
    private int delay = 0;
    private String targetClip = null;

    public ImageClip(String name) {
        super(name);
    }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getDelay() { return delay; }
    public void setDelay(int delay) { this.delay = delay; }

    public String getTargetClip() { return targetClip; }
    public void setTargetClip(String targetClip) { this.targetClip = targetClip; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
