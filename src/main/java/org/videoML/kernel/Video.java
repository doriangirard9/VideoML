package org.videoML.kernel;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Video implements Visitable {
    private String name;
    private Map<Integer, String> order = new HashMap<>();
    private List<Clip> clips = new ArrayList<>();
    private List<Caption> captions = new ArrayList<>();

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

    public List<Caption> getCaptions() {
        return captions;
    }
    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }
    public void addCaption(Caption caption) {
        this.captions.add(caption);
    }

    public Map<Integer, String> getOrder() {
        return order;
    }
    public void setOrder(Map<Integer, String> order) {
        this.order = order;
    }
    public void addOrder(Integer index, String clipHash) {
        this.order.put(index, clipHash);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
