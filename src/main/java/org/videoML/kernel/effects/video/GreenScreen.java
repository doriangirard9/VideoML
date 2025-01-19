package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class GreenScreen extends Effect {
    private int threshold = 150;

    public GreenScreen(int threshold, String clipName) {
        this.threshold = threshold;
        this.setClipName(clipName);
    }
    
    public GreenScreen(String clipName) {
        this.setClipName(clipName);
    }

    public int getThreshold() { return threshold; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
