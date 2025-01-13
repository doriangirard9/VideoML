package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class Transition extends Effect {
    private TransitionType type;
    private double duration;

    public Transition(TransitionType type, double duration, String clipName) {
        this.type = type;
        this.duration = duration;
        setClipName(clipName);
    }

    public TransitionType getType() { return type; }
    public void setType(TransitionType type) { this.type = type; }

    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
