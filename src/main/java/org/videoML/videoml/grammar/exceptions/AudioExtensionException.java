package org.videoML.videoml.grammar.exceptions;

import org.videoML.kernel.clips.video.VideoExtension;

import java.util.Arrays;

public class AudioExtensionException extends RuntimeException {
    public AudioExtensionException(String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }

    public static String buildMessage(String path) {
        String extensions = Arrays.toString(VideoExtension.values());
        return "The audio extension " + path.substring(path.lastIndexOf('.')) + " is not supported. For now, only the following extensions are supported: " + extensions;
    }
}
