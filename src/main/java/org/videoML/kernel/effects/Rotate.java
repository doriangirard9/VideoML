package org.videoML.kernel.effects;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class Rotate extends Effect implements Visitable {

    private int angle;

    public Rotate(int angle, String clipName) {
        this.angle = angle;
        this.setEffectName("rotate");
        this.setClipName(clipName);
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
