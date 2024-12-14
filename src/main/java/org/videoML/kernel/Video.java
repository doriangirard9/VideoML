package org.videoML.kernel;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Video implements Visitable {
    private String name;
    private List<Clip> clips = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Clip> getClips() {
        return clips;
    }
    public void setClips(List<Clip> clips) {
        this.clips = clips;
    }
    public void addClip(Clip clip) {
        this.clips.add(clip);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
