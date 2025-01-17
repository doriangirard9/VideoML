package org.videoML.kernel.clips.audio;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.generator.Visitor;


public class AudioClip extends Clip {
    private String associatedVideoClip; // Reference to the video clip
    private double volume; 
    private String endTime; 
    private String path; 
    private String preceededBy;

    private String onOverlayStart;
    private String onOverlayEnd;

    public AudioClip(String name) {
        this.setName(name);
        this.volume = 1.0;
    }

    public AudioClip(String name, String sourcePath, String path){
        this.setName(name);
        this.setSource(sourcePath);
        this.path = path;
        this.volume = 1.0;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
    
    public String getAssociatedVideoClip() {
        return this.associatedVideoClip;
    }

    public void setAssociatedVideoClip(String videoClipName) {
        this.associatedVideoClip = videoClipName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPreceededBy() {
        return preceededBy;
    }

    public void setPreceededBy(String preceededBy) {
        this.preceededBy = preceededBy;
    }

    public String getOnOverlayStart() {
        return onOverlayStart;
    }

    public void setOnOverlayStart(String onOverlayStart) {
        if (this.associatedVideoClip != null){ 
            this.onOverlayStart = onOverlayStart;
        }
        else {
            System.out.println("You cannot set onOverlayStart for an audio clip that is not associated with a video clip");
        }
    }

    public String getOnOverlayEnd() {
        return onOverlayEnd;
    }

    public void setOnOverlayEnd(String onOverlayEnd) {
        if (this.associatedVideoClip != null){ 
            this.onOverlayEnd = onOverlayEnd;
        }
        else {
            System.out.println("You cannot set onOverlayEnd for an audio clip that is not associated with a video clip");
        }
    }

    @Override
    public String toString() {
        return "AudioClip [name=" + getName() + ", source=" + getSource() + ", volume=" + volume + ", associatedVideoClip=" + associatedVideoClip + ", endTime=" + endTime + "]" + "preceededBy=" + preceededBy + ", onOverlayStart=" + onOverlayStart + ", onOverlayEnd=" + onOverlayEnd;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}
