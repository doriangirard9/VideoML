package org.videoML.kernel.effects;

import org.videoML.kernel.generator.Visitable;

public abstract class Effect implements Visitable {
    private String clipName;

    public String getClipName() { return clipName; }
    protected void setClipName(String clipName) { this.clipName = clipName; }
}
