package org.videoML.kernel;

import org.videoML.kernel.clips.*;
import org.videoML.kernel.clips.video.VideoClip;
import org.videoML.kernel.effects.Freeze;
import org.videoML.kernel.effects.Resize;
import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

import java.util.*;

public class Video implements Visitable {
    private String name;
    private static final String FINAL_CLIP_NAME = "final_clip";
    private List<String> combineClipList = new ArrayList<>(Collections.singletonList(FINAL_CLIP_NAME));
    private List<Clip> timeline = new ArrayList<>();
    private int currentClipIndex = 0;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getCombineClipList() { return combineClipList; }
    public void addCombineClip(String clipName) { combineClipList.add(clipName); }

    public static String getFinalClipName() { return FINAL_CLIP_NAME; }

    public String generateClipName() {
        String clipName = "AUTO_GENERATED_CLIP_" + currentClipIndex;
        currentClipIndex++;
        return clipName;
    }

    public VideoClip getVideoClip(String clipName) {
        Optional<Clip> clip = timeline.stream()
                .filter(c -> (c instanceof VideoClip) && c.getName().equals(clipName))
                .findFirst();

        if (clip.isPresent())
            return (VideoClip) clip.get();
        else
            throw new RuntimeException("Clip not found: " + clipName);
    }

    public List<Clip> getTimeline() { return timeline; }
    public void addTimelineElement(Clip clip) { timeline.add(clip); }

    public void addTransition(String clipName, String effectName, int duration) {
        Optional<Clip> clip = timeline.stream()
                .filter(e -> (e instanceof VideoClip) && (e.getName().equals(clipName)))
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
                .filter(e -> (e instanceof VideoClip) && (e.getName().equals(clipName)))
                .map(e -> (Clip) e)
                .findFirst();

        if (clip.isPresent()) {
            Freeze freeze = new Freeze(timer, duration, clipName);
            clip.get().addEffect(freeze);
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    public void addResize(String clipName, int width, int height, double scale) {
        System.out.println("VIDEO.JAVA ADDING RESIZE EFFECT TO CLIP: " + clipName + " WITH SCALE: " + scale + " AND DIMENSIONS: " + width + "x" + height);
        Optional<Clip> clip = timeline.stream()
                .filter(e -> (e instanceof VideoClip) && (e.getName().equals(clipName)))
                .map(e -> (Clip) e)
                .findFirst();

        if (clip.isPresent()) {
            Resize resize;
            if(width == -1 && height == -1){
                // Scaled resize, without dimensions
                resize = new Resize(scale);
            }
            else {
                // Fixed resize, with dimensions
                resize = new Resize(width, height);
            }
            clip.get().addEffect(resize);
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    public String getStartTimeForClip(String clipName) {
        Optional<Clip> clip = timeline.stream()
                .filter(e -> (e instanceof VideoClip) && (e.getName().equals(clipName)))
                .map(e -> (Clip) e)
                .findFirst();

        if (clip.isPresent()) {
            return clip.get().getStartTime();
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
