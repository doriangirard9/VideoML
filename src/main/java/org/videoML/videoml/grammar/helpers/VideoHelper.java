package org.videoML.videoml.grammar.helpers;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp4.MP4Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.videoML.kernel.clips.VideoExtension;

import java.io.FileInputStream;

public class VideoHelper {

    public static VideoMetadata getMetadata(String path) {
        VideoMetadata videoMetadata = new VideoMetadata();
        try {
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream("src/main/resources/" + path);
            ParseContext pcontext = new ParseContext();

            MP4Parser MP4Parser = new MP4Parser();
            MP4Parser.parse(inputstream, handler, metadata,pcontext);
            String[] metadataNames = metadata.names();

            for(String name : metadataNames) {
                if (name.equals("xmpDM:duration")) {
                    videoMetadata.setDuration(Double.parseDouble(metadata.get(name)));
                } else if (name.equals("tiff:ImageWidth")) {
                    videoMetadata.setWidth(Integer.parseInt(metadata.get(name)));
                } else if (name.equals("tiff:ImageLength")) {
                    videoMetadata.setHeight(Integer.parseInt(metadata.get(name)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return videoMetadata;
    }

    public static boolean checkExtension(String path) {
        String extension = path.substring(path.lastIndexOf('.'));
        for (VideoExtension videoExtension : VideoExtension.values()) {
            if (videoExtension.label.equals(extension)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkTime(String path, String startTime, String endTime) {
        VideoMetadata videoMetadata = getMetadata(path);
        double duration = videoMetadata.getDuration();

        double start = Double.parseDouble(startTime.replace("s", ""));
        double end = Double.parseDouble(endTime.replace("s", ""));

        return !(start < 0) && !(end < 0) && !(start > end) && !(end > duration) && !(start > duration);
    }

}
