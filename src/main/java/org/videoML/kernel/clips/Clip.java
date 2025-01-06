package org.videoML.kernel.clips;

import org.videoML.kernel.TimelineElement;
import org.videoML.kernel.generator.Visitable;

import java.util.ArrayList;
import java.util.List;

public abstract class Clip implements Visitable, TimelineElement {
    private String name;
    private List<Transition> transitions = new ArrayList<>();
    private String startTime = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public void removeTransition(Transition transition) {
        transitions.remove(transition);
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }
}
