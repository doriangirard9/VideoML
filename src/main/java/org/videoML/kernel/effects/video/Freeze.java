package org.videoML.kernel.effects.video;

import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitor;

public class Freeze extends Effect {
    // The start timer of the freeze effect, according to the clip
    private int timer;
    private int duration;

    public Freeze(int timer, int duration, String clipName) {
        this.timer = timer;
        setDuration(duration);
        setClipName(clipName);
    }

    public int getTimer() { return timer; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
