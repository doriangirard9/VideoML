package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.video.*;
import org.videoML.kernel.effects.video.Crop;
import org.videoML.kernel.effects.video.Freeze;
import org.videoML.kernel.effects.video.Resize;
import org.videoML.kernel.effects.video.Rotate;
import org.videoML.kernel.effects.video.SpeedChanger;
import org.videoML.kernel.effects.video.Transition;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(Video video);

    public abstract void visit(VideoClip videoClip);
    public abstract void visit(CutVideoClip cutVideoClip);
    public abstract void visit(TextClip textClip);
    public abstract void visit(CompositeVideoClip compositeVideoClip);
    public abstract void visit(PreviewClip previewClip);

    /****************************************
     ** Effects
     ****************************************/
    
    public abstract void visit(Resize resize);
    public abstract void visit(Transition transition);
    public abstract void visit(Rotate rotate);
    public abstract void visit(SpeedChanger speedChanger);
    public abstract void visit(Freeze freeze);
    public abstract void visit(Crop crop);

    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String,Object> context = new HashMap<>();

    protected T result;

    public T getResult() {
        return result;
    }
}

