package org.videoML.kernel;

import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

import java.util.*;

public class Video implements Visitable {
    private String name;
    private List<TimelineElement> timeline = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<TimelineElement> getTimeline() {
        return timeline;
    }
    public void addTimelineElement(TimelineElement element) {
        timeline.add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
