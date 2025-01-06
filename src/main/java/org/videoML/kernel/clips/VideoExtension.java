package org.videoML.kernel.clips;

public enum VideoExtension {
    MP4(".mp4"),
    MOV(".mov");

    public final String label;

    VideoExtension(String label) {
        this.label = label;
    }
}
