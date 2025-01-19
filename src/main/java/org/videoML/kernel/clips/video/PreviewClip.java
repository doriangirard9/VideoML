package org.videoML.kernel.clips.video;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.generator.Visitor;

public class PreviewClip extends Clip {
    public PreviewClip() {
    }

    public PreviewClip(String name) {
        setName(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
