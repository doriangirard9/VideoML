package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.CutClip;
import org.videoML.kernel.clips.VideoClip;
import org.videoML.kernel.Caption;

import java.util.ArrayList;
import java.util.List;

public class ToWiring extends Visitor<StringBuffer> {
    enum PASS {ONE, TWO}

    private List<Caption> handledCaptions = new ArrayList<>();
    private int sumDuration = 0;

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    @Override
    public void visit(Video video) {
        System.out.println("video order size: " + video.getOrder().size());
        for (int i = 0; i < video.getOrder().size(); i++) {
            System.out.println("video order: " + video.getOrder().get(i));
        }
        w("# Code generated from a VideoML script\n");
        w(String.format("# Video name: %s\n", video.getName()) + "\n");

        w("from moviepy import *\n\n");

        w("font = \"./font/font.ttf\"\n\n");

        List<Clip> clips = video.getClips();
        for (Clip clip : clips) {
            if (clip instanceof VideoClip) {
                VideoClip videoClip = (VideoClip) clip;
                w(String.format("%s = VideoFileClip(\"%s\")\n", videoClip.getName(), videoClip.getPath()));
            } else if (clip instanceof CutClip) {
                CutClip cutClip = (CutClip) clip;
                w(String.format(
                        "%s = VideoFileClip(\"%s\").subclipped(%s, %s)\n",
                        cutClip.getName(), cutClip.getSourcePath(), cutClip.getStartTime().replace("s", ""), cutClip.getEndTime().replace("s", "")
                ));
            }
        }
        w("\n");

        w("video_width = 1280\n");
        w("video_height = 720\n\n");

        w("final_clips = []\n");

        List<Caption> captions = video.getCaptions();
        int captionIndex = 1;

        // put all the captions that are before the first clip and not relative to any other clip
        for (Caption caption : captions) {
            if (caption.getClipName() == null && caption.getRelativeReference() == null) {
                w(String.format(
                        "caption%d = (TextClip(text=\"%s\", font=font, font_size=48, color='white', bg_color='black')"
                                + ".with_duration(%d)"
                                + ".resized(width=video_width, height=video_height)"
                                + ".with_position(('center', 'center'))"
                                + ".with_start(%d))\n",
                        captionIndex, caption.getText(), caption.getDuration(), caption.getStartTime()
                ));

                w(String.format("final_clips.append(caption%d)\n", captionIndex));
                captionIndex++;
                handledCaptions.add(caption);
                sumDuration += caption.getDuration();
            } else {
                break;
            }
        }

        // put all the clips and their captions
        for (Clip clip : clips) {
            String clipName = clip.getName();
            // add with_start to the clip if it's not the first clip (there is a previous caption for example)
            if (clip == clips.get(0) && !handledCaptions.isEmpty()) {
                w(String.format("%s = %s.with_start(%d)\n", clipName, clipName, handledCaptions.get(handledCaptions.size() - 1).getDuration()));
            } else if (clip != clips.get(0)) {
                w(String.format("%s = %s.with_start(%s)\n", clipName, clipName, clips.get(clips.indexOf(clip) - 1).getName() + ".end"));
            }
            w(String.format("final_clips.append(%s)\n", clipName));

            for (Caption caption : captions) {
                if (caption.getClipName() != null && caption.getClipName().equals(clip.getName())) {
                    String startTime = caption.getClipName() != null ? caption.getClipName() + ".start + " + caption.getStartTime() : caption.getStartTime() + "";
                    int duration = caption.getDuration();
                    if (caption.getRelativeReference() != null) {
                        String referenceClip = caption.getRelativeReference();
                        if (caption.getOffset() > 0) {
                            startTime = getClipEndTime(referenceClip, video) + " + " + caption.getOffset();
                        } else {
                            startTime = getClipStartTime(referenceClip, video) + caption.getOffset();
                        }
                    }
                    w(String.format(
                            "caption%d = (TextClip(text=\"%s\", font=font, font_size=48, color='white', bg_color=%s)"
                                    + ".with_duration(%d)"
                                    + ".resized(width=video_width, height=video_height)"
                                    + ".with_position(('center', 'center'))"
                                    + ".with_start(%s))\n",
                            captionIndex, caption.getText(), caption.getClipName() != null ? "None" : "'black'", duration, startTime
                    ));

                    w(String.format("final_clips.append(caption%d)\n", captionIndex));
                    captionIndex++;
                    handledCaptions.add(caption);
                }
            }
        }

        // put all the captions that are after the last clip and not relative to any other clip
        for (Caption caption : captions) {
            if (caption.getClipName() == null && caption.getRelativeReference() == null && !handledCaptions.contains(caption)) {
                w(String.format(
                        "caption%d = (TextClip(text=\"%s\", font=font, font_size=48, color='white', bg_color='black')"
                                + ".with_duration(%d)"
                                + ".resized(width=video_width, height=video_height)"
                                + ".with_position(('center', 'center'))"
                                + ".with_start(%s))\n",
                        captionIndex, caption.getText(), caption.getDuration(), clips.get(clips.size() - 1).getName() + ".end + " + caption.getStartTime()
                ));

                w(String.format("final_clips.append(caption%d)\n", captionIndex));
                captionIndex++;
            }
        }

        w("final_clip = CompositeVideoClip(final_clips)\n");

        w("final_clip.write_videofile(\"output.mp4\", codec=\"libx264\")\n");
    }

    private String[] generateClipNames(List<Clip> clips) {
        return clips.stream().map(Clip::getName).toArray(String[]::new);
    }

    private String getClipStartTime(String clipName, Video video) {
        for (Clip clip : video.getClips()) {
            if (clip.getName().equals(clipName)) {
                return clip.getName() + ".start";
            }
        }

        for (int i = 0; i < video.getCaptions().size(); i++) {
            Caption caption = video.getCaptions().get(i);
            if (clipName.contains(caption.getText())) {
                return "caption" + (i) + ".start";
            }
        }

        return null;
    }

    private String getClipEndTime(String clipName, Video video) {
        for (Clip clip : video.getClips()) {
            if (clip.getName().equals(clipName)) {
                return clip.getName() + ".end";
            }
        }

        for (int i = 0; i < video.getCaptions().size(); i++) {
            Caption caption = video.getCaptions().get(i);
            if (clipName.contains(caption.getText())) {
                return "caption" + (i) + ".end";
            }
        }

        return null;
    }

    @Override
    public void visit(VideoClip videoClip) {
        //
    }

    @Override
    public void visit(CutClip cutClip) {
        //
    }
}
