package org.videoML.kernel.clips;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class Transition implements Visitable {
    private TransitionType type;
    private double duration;
    private String targetClip;

    public Transition(TransitionType type, double duration, String targetClip) {
        this.type = type;
        this.duration = duration;
        this.targetClip = targetClip;
    }

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getTargetClip() {
        return targetClip;
    }

    public void setTargetClip(String targetClip) {
        this.targetClip = targetClip;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
