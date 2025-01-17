package org.videoML.kernel.generator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.Transition;
import org.videoML.kernel.clips.audio.AudioClip;
import org.videoML.kernel.clips.audio.CompositeAudioClip;
import org.videoML.kernel.clips.video.CompositeVideoClip;
import org.videoML.kernel.clips.video.CutVideoClip;
import org.videoML.kernel.clips.video.TextClip;
import org.videoML.kernel.clips.video.VideoClip;
import org.videoML.kernel.effects.Blur;
import org.videoML.kernel.effects.Effect;
import org.videoML.kernel.effects.Freeze;
import org.videoML.kernel.effects.Resize;


public class ToWiring extends Visitor<StringBuffer> {
    private String currentStart = "0";
    private Video video; 

    private Map<String, String> simpleAudioSnippets = new LinkedHashMap<>();
    private Map<String, String> compositeAudioSnippets = new LinkedHashMap<>();

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    @Override
    public void visit(Video video) {
        this.video = video;
        w("# Code generated from a VideoML scrip\n");
        w(String.format("# Video name: %s\n", video.getName()) + "\n");

        w("from moviepy import *\n\n");

        w("font = \"./font/font.ttf\"\n\n");

        w("video_width = 1280\n");
        w("video_height = 720\n\n");

        for (String listName : video.getCombineClipList()) {
            w(String.format("%s_list = []\n", listName));
        }

        for (Clip audioClip : video.getTimeline()) {
            if (audioClip instanceof AudioClip) {
                audioClip.accept(this);
            }
        }

        for (Clip clip : video.getTimeline()) {
            if (clip instanceof VideoClip) {
                clip.accept(this);
            }
        }

        w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", Video.getFinalClipName(), Video.getFinalClipName()));
        w(String.format("%s.write_videofile(\"output.mp4\", codec=\"libx264\")\n", Video.getFinalClipName()));
    }

    @Override
    public void visit(VideoClip videoClip) {
        String startTime = (videoClip.getStartTime() != null) ? videoClip.getStartTime() : currentStart;
        w(String.format("%s = %s.with_start(%s)\n",
            videoClip.getName(), videoClip.getSource(), startTime));

        for (Transition transition : videoClip.getTransitions()) {
            this.visit(transition);
        }


        for(Effect effect: videoClip.getEffects()){
            switch(effect.getEffectName()){
                case "freeze":
                    Freeze freeze = (Freeze) effect;
                    this.visit(freeze);
                    break;
                case "blur":
                    Blur blur = (Blur) effect;
                    this.visit(blur);
                    break;
                case "resize":
                    Resize resize = (Resize) effect;
                    this.visit(resize);
                default:
                    System.err.println("Unsupported effect: " + effect.getEffectName());
                    System.exit(1);
            }
        }

        for (Map.Entry<String, String> entry : compositeAudioSnippets.entrySet()) {
            String compositeName = entry.getKey();
            String code = entry.getValue();
            AudioClip comp = video.getAudioClip(compositeName);
            if (comp != null 
                && comp.getAssociatedVideoClip() != null
                && comp.getAssociatedVideoClip().equals(videoClip.getName())) {
                w(code); 
                w(String.format(
                    "%s = %s.with_audio(%s)\n",
                    videoClip.getName(),
                    videoClip.getName(),
                    comp.getName()
                ));
            }
        }
        
        for (Map.Entry<String, String> entry : simpleAudioSnippets.entrySet()) {
            System.out.println("Key in simple snippets: " + entry.getKey());
            String audioName = entry.getKey(); 
            String code = entry.getValue();
            AudioClip audio = video.getAudioClip(audioName);
            if (audio != null && audio.getAssociatedVideoClip() != null && audio.getAssociatedVideoClip().equals(videoClip.getName())) {
                w(code);  
            }
        }

        w(String.format("%s_list.append(%s)\n", videoClip.getParent(), videoClip.getName()));
        currentStart = String.format("%s.end", videoClip.getName());
    }

    @Override
    public void visit(AudioClip audioClip) {
        StringBuilder sb = new StringBuilder();
        double volume = audioClip.getVolume() != null ? audioClip.getVolume() : 1.0;
        String subclipStart = "0";
        String subclipEnd = "None";

        if (audioClip.getStartTime() != null) {
            subclipStart = audioClip.getStartTime().replace("s", "");
        }
        if (audioClip.getEndTime() != null) {
            subclipEnd = audioClip.getEndTime().replace("s", "");
        }
        if (audioClip.getAssociatedVideoClip() != null) {
            sb.append(String.format(
                "%s = %s.subclipped(%s, %s)"                      
                + ".with_start(%s)"       
                + ".with_end(%s)"                 
                + ".with_effects([afx.MultiplyVolume(%.1f)])\n", 
                audioClip.getName(),
                audioClip.getSource(),
                subclipStart,
                subclipEnd,
                audioClip.getPreceededBy(),
                audioClip.getEndTime(),
                volume
            ));
        }

        else {
            sb.append(String.format(
                "%s = %s.subclipped(%s, %s)"
                + ".with_start(%s)"
                + ".with_effects([afx.MultiplyVolume(%.1f)])\n",
                audioClip.getName(),
                audioClip.getSource(),
                subclipStart,
                subclipEnd,
                audioClip.getPreceededBy(),
                volume
            ));
        }
        
        if (audioClip.getAssociatedVideoClip() != null) {
            String associatedVideo = audioClip.getAssociatedVideoClip();
            sb.append(String.format(
                "%s = %s.with_audio(%s)\n",
                associatedVideo,
                associatedVideo,
                audioClip.getName()
            ));
        } 
        else {
            sb.append("# AudioClip not associated with a video.\n");
        }
        simpleAudioSnippets.put(audioClip.getName(), sb.toString());
        System.out.println("Inserting in simple audio snippets: \n" + sb.toString() + " \nFor audio: " + audioClip.getName() + "\n");
    }

    @Override
    public void visit(CompositeAudioClip compositeAudioClip) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s_list = []\n", compositeAudioClip.getName()));
        for (AudioClip audioClip : compositeAudioClip.getAudioClips()) {
            String childSnippet = simpleAudioSnippets.get(audioClip.getName());
            if (childSnippet != null) {
                sb.append(childSnippet);
            }
            sb.append(String.format("%s_list.append(%s)\n", compositeAudioClip.getName(), audioClip.getName()));
        }

        String subclipStart = "0";
        String subclipEnd   = "None";
        if (compositeAudioClip.getStartTime() != null) {
            subclipStart = compositeAudioClip.getStartTime().replace("s", "");
        }
        if (compositeAudioClip.getEndTime() != null) {
            subclipEnd = compositeAudioClip.getEndTime().replace("s", "");
        }

        String snippet = "";
        if (compositeAudioClip.getAssociatedVideoClip() != null) {
            snippet = String.format(
                "%s = CompositeAudioClip(%s_list).with_start(%s).with_end(%s).subclipped(%s, %s)\n",
                compositeAudioClip.getName() ,
                compositeAudioClip.getName(),
                compositeAudioClip.getOnOverlayStart(),
                compositeAudioClip.getOnOverlayEnd(),
                subclipStart,
                subclipEnd
            );
        } 
        else {
            snippet = String.format(
                "%s = CompositeAudioClip(%s_list).subclipped(%s, %s)\n",
                compositeAudioClip.getName(),
                compositeAudioClip.getName(),
                subclipStart,
                subclipEnd
            );
        }
        sb.append(snippet);
        compositeAudioSnippets.put(compositeAudioClip.getName(), sb.toString());
    }

    @Override
    public void visit(CutVideoClip cutVideoClip) {
        String startTime = (cutVideoClip.getStartTime() != null) ? cutVideoClip.getStartTime() : currentStart;
        w(String.format("%s = %s.subclipped(%s, %s).with_start(%s)\n",
                cutVideoClip.getName(), cutVideoClip.getSource(),
                cutVideoClip.getStart().replace("s", ""),
                cutVideoClip.getEnd().replace("s", ""),
                startTime));
        
        w(String.format("%s_list.append(%s)\n", cutVideoClip.getParent(), cutVideoClip.getName()));
        currentStart = String.format("%s.end", cutVideoClip.getName());
    }

    @Override
    public void visit(TextClip textClip) {
        String duration = String.format("%d", textClip.getDuration());
        String startTime = currentStart;

        if (textClip.getTargetClip() != null) {
            startTime = String.format("%s.start + %d", textClip.getTargetClip(), textClip.getDelay()); ;

            // if duration is unset the text will sync with the target clip
            if (textClip.getDuration() == 0)
                duration = String.format("%s.start + %s.end - %d", textClip.getTargetClip(), textClip.getTargetClip(), textClip.getDelay());
        }

        w(String.format("%s = TextClip(text=\"%s\", font=font, font_size=48, color='white')"
                + ".with_position('center')"
                + ".with_start(%s)"
                + ".with_duration(%s)\n",
                textClip.getName(), textClip.getText(), startTime, duration));

        // Only update currentStart when textClip is standalone        
        if (textClip.getTargetClip() == null) {
            currentStart = String.format("%s.end", textClip.getName());
        }

        w(String.format("%s_list.append(%s)\n", textClip.getParent(), textClip.getName()));
    }

    @Override
    public void visit(CompositeVideoClip compositeVideoClip) {
        w(String.format("%s = CompositeVideoClip(%s_list, size=(video_width, video_height))\n", 
            compositeVideoClip.getName(),
            compositeVideoClip.getName()));

        w(String.format("%s_list.append(%s)\n", compositeVideoClip.getParent(), compositeVideoClip.getName()));
        currentStart = String.format("%s.end", compositeVideoClip.getName());
    }

    @Override
    public void visit(Transition transition) {
        String transitionEffect = "";
        switch (transition.getType()) {
            case FADEIN:
                transitionEffect = String.format("vfx.FadeIn(%s)", transition.getDuration());
                break;
            case FADEOUT:
                transitionEffect = String.format("vfx.FadeOut(%s)", transition.getDuration());
                break;
            default:
                throw new IllegalArgumentException("Unsupported transition type: " + transition.getType());
        }

        String targetClip = transition.getTargetClip();
        if (targetClip != null) {
            w(String.format("%s = %s.with_effects([%s])\n",
                    targetClip, targetClip, transitionEffect));
        }
    }

    @Override
    public void visit(Freeze freeze) {
        String targetClip = freeze.getClipName();
        String freezeEffect = String.format("vfx.Freeze(%s, %s)", freeze.getTimer(), freeze.getDuration());

        if(targetClip != null) {
            w(String.format("%s = %s.with_effects([%s])\n",
                    targetClip, targetClip, freezeEffect));
            // We need to re-set the start/end timers after applying an effect
        }
    }

    @Override
    public void visit(Blur blur) {
        // TODO NOT YET IMPLEMENTED
        return;
    }

    @Override
    public void visit(Resize resize) {
        System.out.println("VISITING RESIZE EFFECT");
        String targetClip = resize.getClipName();

        if(resize.isScale){
            w(String.format("%s = %s.resized(%f)\n",
                    targetClip, targetClip, resize.getScale()));
        }
        else {
            w(String.format("%s = %s.resized(width=%d, height=%d)\n",
                    targetClip, targetClip, resize.getWidth(), resize.getHeight()));
        }
    }
}