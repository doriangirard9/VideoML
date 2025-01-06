package org.videoML.kernel;

import org.videoML.kernel.clips.*;
import org.videoML.kernel.effects.Freeze;
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

    public void addTransition(String clipName, String effectName, int duration) {
        Optional<Clip> clip = timeline.stream()
                .filter(e -> (e instanceof VideoClip || e instanceof CutClip) && (e.getName().equals(clipName)))
                .map(e -> (Clip) e)
                .findFirst();

        if (clip.isPresent()) {
            Transition transition = new Transition(TransitionType.valueOf(effectName.toUpperCase()), duration, clipName);
            clip.get().addTransition(transition);
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    public void addFreeze(float timer, int duration, String clipName){
        // We can only freeze video clips (or cutclips)
        System.out.println("ADDING FREEZE EFFECT TO CLIP: " + clipName + " WITH TIMER: " + timer + " AND DURATION: " + duration);
        Optional<Clip> clip = timeline.stream()
                .filter(e -> (e instanceof VideoClip || e instanceof CutClip) && (e.getName().equals(clipName)))
                .map(e -> (Clip) e)
                .findFirst();

        if (clip.isPresent()) {
            Freeze freeze = new Freeze(timer, duration, clipName);
            clip.get().addEffect(freeze);
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
