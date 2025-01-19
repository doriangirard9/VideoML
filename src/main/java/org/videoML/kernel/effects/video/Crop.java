package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class Crop extends Effect {
    // crop in percentage
    private int x1, y1, x2, y2;

    public Crop(String clipName, int x1, int y1, int x2, int y2) {
        setClipName(clipName);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
