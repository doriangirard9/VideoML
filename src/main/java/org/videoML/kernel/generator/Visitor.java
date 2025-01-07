package org.videoML.kernel.generator;

import org.videoML.kernel.Caption;
import org.videoML.kernel.Video;
import org.videoML.kernel.clips.CutClip;
import org.videoML.kernel.clips.Transition;
import org.videoML.kernel.clips.VideoClip;
import org.videoML.kernel.effects.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(Video video);

    public abstract void visit(VideoClip videoClip);
    public abstract void visit(CutClip cutClip);
    public abstract void visit(Caption caption);
    public abstract void visit(Transition transition);

    /****************************************
     ** Effects
     ****************************************/

    public abstract void visit(Freeze freeze);
    public abstract void visit(Blur blur);
    public abstract void visit(Resize resize);
    public abstract void visit(Rotate rotate);
    public abstract void visit(SpeedChanger speedChanger);

    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String,Object> context = new HashMap<>();

    protected T result;

    public T getResult() {
        return result;
    }
}

