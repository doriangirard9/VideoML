package org.videoML.kernel.clips;

import org.videoML.kernel.generator.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VideoClip extends ImportableClip {
    private double scale = 1.0;
    private String positionX = "center";
    private String positionY = "center";

    public VideoClip(String name, String path) {
        this.setName(name);
        this.setPath(path);
    }

    public double getScale() {
        return scale;
    }
    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getPositionX() {
        return positionX;
    }
    public String getPositionY() {
        return positionY;
    }
    public void setPosition(String positionX, String positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
