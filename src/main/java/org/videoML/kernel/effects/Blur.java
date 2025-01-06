package org.videoML.kernel.effects;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class Blur extends Effect implements Visitable {
    private double duration;
    private double radius;

    public Blur(double duration, double radius) {
        this.duration = duration;
        this.radius = radius;
        this.setEffectName("blur");
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
