package org.videoML.kernel;

import org.videoML.kernel.clips.*;
import org.videoML.kernel.clips.video.VideoClip;
import org.videoML.kernel.generator.Visitable;
import org.videoML.kernel.generator.Visitor;

import java.util.*;

public class Video implements Visitable {
    private String name;
    private int fps = 24;
    private int width = 1280;
    private int height = 720;
    private static final String FINAL_CLIP_NAME = "final_clip";
    
    private List<String> combineClipList = new ArrayList<>(Collections.singletonList(FINAL_CLIP_NAME));
    private List<Clip> timeline = new ArrayList<>();
    private int currentClipIndex = 0;

    public int getFps() { return fps; }
    public void setFps(int fps) { this.fps = fps; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getCombineClipList() { return combineClipList; }
    public void addCombineClip(String clipName) { combineClipList.add(clipName); }

    public static String getFinalClipName() { return FINAL_CLIP_NAME; }
    
    public List<Clip> getTimeline() { return timeline; }
    public void addTimelineElement(Clip clip) { timeline.add(clip); }
    
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
