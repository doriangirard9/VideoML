package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.VideoClip;
import org.videoML.kernel.Caption;

import java.util.List;

public class ToWiring extends Visitor<StringBuffer> {
    enum PASS {ONE, TWO}

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

        List<Clip> clips = video.getClips();
        for (int i = 0; i < clips.size(); i++) {
            Clip clip = clips.get(i);
            if (!(clip instanceof VideoClip)) {
                throw new RuntimeException("Unsupported clip type: " + clip.getClass().getName());
            }
            w(String.format("clip%d = VideoFileClip(\"%s\")\n", i + 1, ((VideoClip) clip).getPath()));
        }
        w("\n");

        if (clips.size() > 1) {
            String combinedClips = String.join(", ", generateClipNames(clips.size()));
            w(String.format("combined_clip = concatenate_videoclips([%s])\n", combinedClips));
        } else if (clips.size() == 1) {
            w("combined_clip = clip1\n");
        }
        w("\n");

        w("video_width, video_height = combined_clip.size\n\n");

        List<Caption> captions = video.getCaptions();
        int captionIndex = 1;
        for (Caption caption : captions) {
            w(String.format(
                    "caption%d = (TextClip(text=\"%s\", font=font, font_size=48, color='white', bg_color='black')"
                            + ".with_duration(%d)"
                            + ".resized(width=video_width)"
                            + ".with_position('center'))\n",
                    captionIndex, caption.getText(), caption.getDuration()
            ));
            captionIndex++;
        }
        w("\n");

        w("final_clips = []\n");
        captionIndex = 1;
        for (Caption caption : captions) {
            w(String.format("final_clips.append(caption%d)\n", captionIndex));
            if (captionIndex == 1) {
                w("final_clips.append(combined_clip)\n");
            }
            captionIndex++;
        }
        w("final_clip = concatenate_videoclips(final_clips, method='compose')\n");

        w("final_clip.write_videofile(\"output.mp4\", codec=\"libx264\")\n");
    }

    private String[] generateClipNames(int count) {
        String[] clipNames = new String[count];
        for (int i = 0; i < count; i++) {
            clipNames[i] = String.format("clip%d", i + 1);
        }
        return clipNames;
    }

    @Override
    public void visit(VideoClip videoClip) {
    }
}
