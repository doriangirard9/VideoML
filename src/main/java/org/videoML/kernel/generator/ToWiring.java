package org.videoML.kernel.generator;

import org.videoML.kernel.Video;

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
        w("// Code generated from a VideoML script\n");
        w(String.format("// Video name: %s\n", video.getName())+"\n");
    }
}
