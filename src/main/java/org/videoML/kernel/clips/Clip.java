package org.videoML.kernel.clips;

import org.videoML.kernel.generator.Visitable;

public abstract class Clip implements Visitable {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
