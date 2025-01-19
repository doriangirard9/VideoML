package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class Rotate extends Effect {
    private int angle;

    public Rotate(int angle, String clipName) {
        this.angle = angle;
        this.setClipName(clipName);
    }

    public int getAngle() { return angle; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
