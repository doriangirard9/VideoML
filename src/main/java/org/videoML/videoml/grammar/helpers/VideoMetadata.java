package org.videoML.videoml.grammar.helpers;

public class VideoMetadata {
    public int width;
    public int height;
    public double duration;

    public VideoMetadata() {

    }

    public VideoMetadata(int width, int height, double duration) {
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
