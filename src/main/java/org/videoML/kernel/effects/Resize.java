package org.videoML.kernel.effects;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class Resize extends Effect implements Visitable {

    private int width;
    private int height;
    private double scale;

    public boolean isScale;

    public Resize(int width, int height, String clipName) {
        this.width = width;
        this.height = height;
        this.isScale = false;
        this.setEffectName("resize");
        this.setClipName(clipName);
    }

    public Resize(double scale, String clipName) {
        this.scale = scale;
        this.isScale = true;
        this.setEffectName("resize");
        this.setClipName(clipName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getScale() {
        return scale;
    }
}
