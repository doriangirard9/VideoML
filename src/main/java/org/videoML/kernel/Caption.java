package org.videoML.kernel;

public class Caption {
    private String text;
    private int duration;

    public Caption(String text, int duration) {
        this.text = text;
        this.duration = duration;
    }

    public String getText() {
        return text;
    }

    public int getDuration() {
        return duration;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
