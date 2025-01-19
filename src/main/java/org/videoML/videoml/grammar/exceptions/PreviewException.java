package org.videoML.videoml.grammar.exceptions;

public class PreviewException extends RuntimeException {
    public PreviewException(String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }
}
