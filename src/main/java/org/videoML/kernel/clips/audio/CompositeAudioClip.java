package org.videoML.kernel.clips.audio;

import org.videoML.kernel.generator.Visitor;
import java.util.ArrayList;
import java.util.List;

public class CompositeAudioClip extends AudioClip{
    private List<AudioClip> audioClips = new ArrayList<>();

    public CompositeAudioClip(String name) {
        super(name);
    }

    public List<AudioClip> getAudioClips() {
        return audioClips;
    }

    public void addAudioClip(AudioClip audioClip) {
        audioClips.add(audioClip);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
