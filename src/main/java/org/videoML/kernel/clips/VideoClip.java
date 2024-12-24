package org.videoML.kernel.clips;

import org.videoML.kernel.TimelineElement;
import org.videoML.kernel.generator.Visitor;

public class VideoClip extends ImportableClip implements TimelineElement {

    public VideoClip(String name, String path) {
        this.setName(name);
        this.setPath(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
