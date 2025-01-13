package org.videoML.kernel.clips.video;

import org.videoML.kernel.generator.Visitor;

public class CutVideoClip extends VideoClip {
    private String start;
    private String end;

    public CutVideoClip(String name, String source) {
        super(name, source);
    }

    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }
    
    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
