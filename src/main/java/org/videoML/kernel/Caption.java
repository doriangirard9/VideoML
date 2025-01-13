package org.videoML.kernel;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

public class Caption implements TimelineElement {
    private String text;
    private int duration;
    private String clipName;
    private int startTime;
    private int offset;
    private String relativeReference;

    public Caption(String text, int duration) {
        this.text = text;
        this.duration = duration;
    }

    public Caption(String text, String clipName, int startTime, int duration) {
        this.text = text;
        this.clipName = clipName;
        this.startTime = startTime;
        this.duration = duration;
    }

    public Caption(String text, String clipName, int offset, String relativeReference, int duration) {
        this.text = text;
        this.clipName = clipName;
        this.offset = offset;
        this.relativeReference = relativeReference;
        this.duration = duration;
    }

    @Override
    public String getName() {
        return text;
    }

    public String getText() {
        return text;
    }

    public int getDuration() {
        return duration;
    }

    public String getClipName() {
        return clipName;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getOffset() {
        return offset;
    }

    public String getRelativeReference() {
        return relativeReference;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setClipName(String clipName) {
        this.clipName = clipName;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setRelativeReference(String relativeReference) {
        this.relativeReference = relativeReference;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "text='" + text + '\'' +
                ", duration=" + duration +
                ", clipName='" + clipName + '\'' +
                ", startTime=" + startTime +
                ", offset=" + offset +
                ", relativeReference='" + relativeReference + '\'' +
                '}';
    }
}
