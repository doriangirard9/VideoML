package org.videoML.kernel;

import java.util.ArrayList;
import java.util.List;

public class Timeline {
    private final List<TimelineElement> elements;

    public Timeline() {
        this.elements = new ArrayList<>();
    }

    public void addElement(TimelineElement element) {
        elements.add(element);
    }

    public List<TimelineElement> getElements() {
        return new ArrayList<>(elements);
    }

    public void clear() {
        elements.clear();
    }
}
