package org.videoML.kernel.clips;

import org.videoML.kernel.Video;
import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.generator.Visitable;

import java.util.ArrayList;
import java.util.List;

public abstract class Clip implements Visitable {
    private String name;
    private String source = null;
    protected String startTime = null;
    private String parent = Video.getFinalClipName();

    private List<Effect> effects = new ArrayList<>();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getStartTime() { return startTime; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public void addEffect(Effect effect) { effects.add(effect); }
    public List<Effect> getEffects() { return effects; }
}