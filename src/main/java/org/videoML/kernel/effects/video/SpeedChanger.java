package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class SpeedChanger extends Effect {
    private final double factor;

    public SpeedChanger(String clipName, double percentage, boolean isSpeedUp) {
        this.setClipName(clipName);
        this.factor = isSpeedUp ? 1 + (percentage / 100) : Math.max(1 - (percentage / 100), 0.001);
    }

    public double getFactor() { return factor; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
