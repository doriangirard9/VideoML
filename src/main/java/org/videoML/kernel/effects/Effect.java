package org.videoML.kernel.effects;

public abstract class Effect {
    private double duration;
    private String clipName;
    private String effectName;

    public String getEffectName() {
        return effectName;
    }

    protected void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public double getDuration() {
        return duration;
    }

    protected void setDuration(double duration) {
        this.duration = duration;
    }

    public String getClipName() {
        return clipName;
    }

    protected void setClipName(String clipName) {
        this.clipName = clipName;
    }
}
