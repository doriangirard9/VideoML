package org.videoML.kernel.clips.video;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.generator.Visitor;

public class VideoClip extends Clip {
    private String positionX = "center";
    private String positionY = "center";

    public VideoClip(String name) {
        this.setName(name);
    }

    public VideoClip(String name, String source) {
        this.setName(name);
        this.setSource(source);
    }

    public String getPositionX() { return positionX; }
    public String getPositionY() { return positionY; }

    public void setPosition(String positionX, String positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
