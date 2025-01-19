package org.videoML.kernel.clips.video;

import org.videoML.kernel.generator.Visitor;

public class TextClip extends VideoClip {
    private String text;
    private int duration = 0;
    private int delay = 0;
    private String targetClip = null;

    public TextClip(String name) {
        super(name);
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

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
