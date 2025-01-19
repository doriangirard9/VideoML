package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class Resize extends Effect {
    private int width;
    private int height;
    private double scale;
    public boolean isScale;

    public Resize(int width, int height, String clipName) {
        this.width = width;
        this.height = height;
        this.isScale = false;
        this.setClipName(clipName);
    }

    public Resize(double scale, String clipName) {
        this.scale = scale;
        this.isScale = true;
        this.setClipName(clipName);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public double getScale() { return scale; }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
