package org.videoML.videoml.grammar.exceptions;


public class VideoTimeException extends RuntimeException {
    public VideoTimeException(String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }

    public static String buildMessage(String path, String startTime, String endTime) {
        return "The time range " + startTime + " - " + endTime + " is invalid for the video " + path;
    }

}
