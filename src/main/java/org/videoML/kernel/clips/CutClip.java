package org.videoML.kernel.clips;

import org.videoML.kernel.TimelineElement;
import org.videoML.kernel.generator.Visitor;

public class CutClip extends Clip implements TimelineElement {
    private String sourcePath;
    private String startTime;
    private String endTime;

    public CutClip(String name, String sourcePath, String startTime, String endTime) {
        this.setName(name);
        this.sourcePath = sourcePath;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
