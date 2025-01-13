package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Transition;
import org.videoML.kernel.clips.video.CompositeVideoClip;
import org.videoML.kernel.clips.video.CutVideoClip;
import org.videoML.kernel.clips.video.TextClip;
import org.videoML.kernel.clips.video.VideoClip;
import org.videoML.kernel.effects.Blur;
import org.videoML.kernel.effects.Freeze;
import org.videoML.kernel.effects.Resize;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(Video video);

    public abstract void visit(VideoClip videoClip);
    public abstract void visit(CutVideoClip cutVideoClip);
    public abstract void visit(TextClip textClip);
    public abstract void visit(CompositeVideoClip compositeVideoClip);

    public abstract void visit(Transition transition);

    /****************************************
     ** Effects
     ****************************************/

    public abstract void visit(Freeze freeze);
    public abstract void visit(Blur blur);
    public abstract void visit(Resize resize);

    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String,Object> context = new HashMap<>();

    protected T result;

    public T getResult() {
        return result;
    }
}

