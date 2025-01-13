package org.videoML.kernel.clips.video;

import java.util.ArrayList;
import java.util.List;

import org.videoML.kernel.generator.Visitor;

public class CompositeVideoClip extends VideoClip {
    private List<VideoClip> clips = new ArrayList<>();

    public CompositeVideoClip(String name) {
        super(name);
    }

    public List<VideoClip> getClips() { return clips; }
    public void addClip(VideoClip clip) { clips.add(clip); }

    @Override
    public void setStartTime(String startTime) {
        // Here we assume that the first clip in the list
        // is the one that starts the soonest
        clips.get(0).setStartTime(startTime);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
