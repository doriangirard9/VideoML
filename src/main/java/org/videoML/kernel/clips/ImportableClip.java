package org.videoML.kernel.clips;

public abstract class ImportableClip extends Clip {
    private String path;

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
