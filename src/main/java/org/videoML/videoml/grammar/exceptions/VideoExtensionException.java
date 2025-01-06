package org.videoML.videoml.grammar.exceptions;

import org.videoML.kernel.clips.VideoExtension;

import java.util.Arrays;

public class VideoExtensionException extends RuntimeException {
    public VideoExtensionException(String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }

    public static String buildMessage(String path) {
        String extensions = Arrays.toString(VideoExtension.values());
        return "The video extension " + path.substring(path.lastIndexOf('.')) + " is not supported. For now, only the following extensions are supported: " + extensions;
    }
}
