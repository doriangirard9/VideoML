package org.videoML.kernel.generator;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.VideoClip;

public class ToWiring extends Visitor<StringBuffer> {
    enum PASS {ONE, TWO}

    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s",s));
    }

    @Override
    public void visit(Video video) {
        w("# Code generated from a VideoML script\n");
        w(String.format("# Video name: %s\n", video.getName())+"\n");

        w("from moviepy import *\n\n\n");

        for (Clip clip: video.getClips()) {
            clip.accept(this);
        }
    }

    @Override
    public void visit(VideoClip videoClip) {
        w(String.format("clip_%s = VideoFileClip(%s)\n", videoClip.getName(), videoClip.getPath()));
    }
}
