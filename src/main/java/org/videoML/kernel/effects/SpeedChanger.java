package org.videoML.kernel.effects;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class SpeedChanger extends Effect implements Visitable {

    private final double factor;

    public SpeedChanger(String clipName, double percentage, boolean isSpeedUp) {
        this.setEffectName("speedChanger");
        this.setClipName(clipName);
        this.factor = isSpeedUp ? 1+(percentage/100) : 1-(percentage/100);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getFactor() {
        return factor;
    }
}
