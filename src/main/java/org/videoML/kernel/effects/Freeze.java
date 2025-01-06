package org.videoML.kernel.effects;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class Freeze extends Effect implements Visitable {
    private double timer;
    // The start timer of the freeze effect, according to the clip

    public Freeze(double timer, double duration, String clipName) {
        this.setDuration(duration);
        this.setClipName(clipName);
        this.timer = timer;
        this.setEffectName("freeze");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getTimer() {
        return timer;
    }
}
