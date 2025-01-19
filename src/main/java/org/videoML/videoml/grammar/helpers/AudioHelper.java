package org.videoML.videoml.grammar.helpers;

import org.videoML.kernel.clips.audio.AudioExtension;


public class AudioHelper {
    public static boolean isValidExtension(String path) {
        String extension = path.substring(path.lastIndexOf('.'));
        for (AudioExtension audioExtension : AudioExtension.values()) {
            if (audioExtension.label.equals(extension)) {
                return true;
            }
        }
        return false;
    }
}
