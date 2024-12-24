package org.videoML.kernel.generator;

import org.videoML.kernel.TimelineElement;
import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.CutClip;
import org.videoML.kernel.clips.VideoClip;
import org.videoML.kernel.Caption;


public class ToWiring extends Visitor<StringBuffer> {
    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    @Override
    public void visit(Video video) {
        w("# Code generated from a VideoML script\n");
        w(String.format("# Video name: %s\n", video.getName()) + "\n");

        w("from moviepy import *\n\n");

        w("font = \"./font/font.ttf\"\n\n");

        w("video_width = 1280\n");
        w("video_height = 720\n\n");

        w("final_clips = []\n");
        int captionIndex = 1;
        String currentStart = "0";

        for (TimelineElement element : video.getTimeline()) {
            if (element instanceof Caption) {
                Caption caption = (Caption) element;
                String startExpression;

                if (caption.getClipName() == null) {
                    // Standalone caption
                    startExpression = currentStart;
                } else if (caption.getRelativeReference() != null) {
                    // Relative reference
                    String referenceClip = caption.getRelativeReference();
                    String startTime;
                    if (caption.getOffset() > 0) {
                        startTime = getClipEndTime(referenceClip, video) + " + " + caption.getOffset();
                    } else {
                        startTime = getClipStartTime(referenceClip, video) + caption.getOffset();
                    }
                    startExpression = String.format("%s + %d", startTime, caption.getStartTime());
                } else {
                    // Tied to a clip
                    startExpression = String.format("%s.start + %d", caption.getClipName(), caption.getStartTime());
                }

                w(String.format(
                        "caption%d = (TextClip(text=\"%s\", font=font, font_size=48, color='white')"
                                + ".with_duration(%d)"
                                + ".with_position('center')"
                                + ".with_start(%s))\n",
                        captionIndex, caption.getText(), caption.getDuration(), startExpression
                ));
                w(String.format("final_clips.append(caption%d)\n", captionIndex));

                // Only update currentStart when caption is standalone
                if (caption.getClipName() == null && caption.getRelativeReference() == null) {
                    currentStart = String.format("caption%d.end", captionIndex);
                }
                captionIndex++;
            } else if (element instanceof VideoClip) {
                VideoClip videoClip = (VideoClip) element;
                w(String.format("%s = VideoFileClip(\"%s\").with_start(%s)\n",
                        videoClip.getName(), videoClip.getPath(), currentStart));
                w(String.format("final_clips.append(%s)\n", videoClip.getName()));
                currentStart = String.format("%s.end", videoClip.getName());
            } else if (element instanceof CutClip) {
                CutClip clipCut = (CutClip) element;
                w(String.format("%s = VideoFileClip(\"%s\").subclipped(%s, %s).with_start(%s)\n",
                        clipCut.getName(), clipCut.getSourcePath(),
                        clipCut.getStartTime().replace("s", ""),
                        clipCut.getEndTime().replace("s", ""),
                        currentStart));
                w(String.format("final_clips.append(%s)\n", clipCut.getName()));
                currentStart = String.format("%s.end", clipCut.getName());
            }
        }

        w("final_clip = CompositeVideoClip(final_clips, size=(video_width, video_height))\n");
        w("final_clip.write_videofile(\"output.mp4\", codec=\"libx264\")\n");
    }

    private String getClipStartTime(String clipName, Video video) {
        int captionIndex = 1;
        for (TimelineElement element : video.getTimeline()) {
            if (element instanceof Clip) {
                if (element.getName().equals(clipName)) {
                    return element.getName() + ".start";
                }
            } else if (element instanceof Caption) {
                Caption caption = (Caption) element;
                if (clipName.contains(caption.getText())) {
                    return String.format("caption%d.start", captionIndex);
                }
                captionIndex++;
            }
        }
        return null;
    }

    private String getClipEndTime(String clipName, Video video) {
        int captionIndex = 1;
        for (TimelineElement element : video.getTimeline()) {
            if (element instanceof Clip) {
                if (element.getName().equals(clipName)) {
                    return element.getName() + ".end";
                }
            } else if (element instanceof Caption) {
                Caption caption = (Caption) element;
                if (clipName.contains(caption.getText())) {
                    return String.format("caption%d.end", captionIndex);
                }
                captionIndex++;
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