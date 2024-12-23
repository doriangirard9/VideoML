package org.videoML.videoml.grammar;

import org.videoML.kernel.Video;
import org.videoML.kernel.Caption;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.CutClip;
import org.videoML.kernel.clips.VideoClip;
import videoml.grammar.VideoMLBaseListener;
import videoml.grammar.VideoMLParser;

public class ModelBuilder extends VideoMLBaseListener {
    private Video video = null;
    private boolean built = false;

    public Video retrieve() {
        if (built) {
            return video;
        }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    @Override
    public void enterRoot(VideoMLParser.RootContext ctx) {
        System.out.println("Entering root");
        built = false;
        video = new Video();
    }

    @Override
    public void exitRoot(VideoMLParser.RootContext ctx) {
        System.out.println("Exiting root");
        this.built = true;
    }

    @Override
    public void enterProjectName(VideoMLParser.ProjectNameContext ctx) {
        System.out.println("Project name is: " + ctx.IDENTIFIER().getText());
        video.setName(ctx.IDENTIFIER().getText());
    }

    @Override
    public void enterCut(VideoMLParser.CutContext ctx) {
        String sourcePath = ctx.STRING().getText().replace("\"", "");
        String startTime = ctx.time(0).getText();
        String endTime = ctx.time(1).getText();
        String name = ctx.IDENTIFIER().getText();

        System.out.println("Cutting clip: " + sourcePath + " from " + startTime + " to " + endTime + " as " + name);
        CutClip cutClip = new CutClip(name, sourcePath, startTime, endTime);
        video.addClip(cutClip);
        video.addOrder(video.getOrder().size(), cutClip.hashCode() + "");
    }

    /*
    caption         : 'caption' STRING ('on' IDENTIFIER)? (duration | offset | offsetWithDuration)? ;
    duration        : 'for' time ;
    offset          : 'from' from=time 'to' to=time
                    | NUMBER 's' ('after' after=IDENTIFIER | 'before' before=IDENTIFIER)? ;
    offsetWithDuration
    : offset duration ;
    time             : NUMBER 's' ;

     */
    @Override
    public void enterCaption(VideoMLParser.CaptionContext ctx) {
        String text = ctx.STRING().getText().replace("\"", "");
        int duration = 0;
        String clipName = null;
        int offsetValue = 0;
        String relativeClipOrCaption = null;
        String beforeOrAfter = null;

        // ('on' IDENTIFIER)?
        if (ctx.IDENTIFIER() != null) {
            clipName = ctx.IDENTIFIER().getText();
        }

        // offset duration => offsetWithDuration
        if (ctx.offsetWithDuration() != null) {
            offsetValue = Integer.parseInt(ctx.offsetWithDuration().offset().NUMBER().getText()) * (ctx.offsetWithDuration().offset().after != null ? 1 : -1);
            duration = Integer.parseInt(ctx.offsetWithDuration().duration().time().getText().replace("s", ""));
            relativeClipOrCaption = ctx.offsetWithDuration().offset().after != null ?
                    ctx.offsetWithDuration().offset().after.getText() :
                    ctx.offsetWithDuration().offset().before.getText();
            beforeOrAfter = ctx.offsetWithDuration().offset().after != null ? "after" : "before";
        } else {
            // 'for' time
            if (ctx.duration() != null) {
                duration = Integer.parseInt(ctx.duration().time().getText().replace("s", ""));
            }

            // 'from' from=time 'to' to=time
            // | NUMBER 's' ('after' after=IDENTIFIER | 'before' before=IDENTIFIER)? ;
            if (ctx.offset() != null) {
                if (ctx.offset().from != null) {
                    int from = Integer.parseInt(ctx.offset().from.getText().replace("s", ""));
                    int to = Integer.parseInt(ctx.offset().to.getText().replace("s", ""));
                    offsetValue = to - from;
                    duration = to - from;
                } else {
                    if (ctx.offset().after != null) {
                        relativeClipOrCaption = ctx.offset().after.getText();
                        beforeOrAfter = "after";
                    } else if (ctx.offset().before != null) {
                        relativeClipOrCaption = ctx.offset().before.getText();
                        beforeOrAfter = "before";
                    }
                    offsetValue = Integer.parseInt(ctx.offset().NUMBER().getText().replace("s", "")) * (ctx.offset().after != null ? 1 : -1);
                }
            }
        }


        System.out.printf(
                "Adding caption: %s on clip %s at %d seconds %s %s for %d seconds%n",
                text, clipName, offsetValue, beforeOrAfter, relativeClipOrCaption, duration
        );

        Caption caption = new Caption(text, clipName, offsetValue, relativeClipOrCaption, duration);
        video.addCaption(caption);
        video.addOrder(video.getOrder().size(), caption.hashCode() + "");
    }

    @Override
    public void enterCombine(VideoMLParser.CombineContext ctx) {
        System.out.println("Combining clips...");
        for (int i = 0; i < ctx.STRING().size(); i++) {
            String clipPath = ctx.STRING(i).getText().replace("\"", "");
            String clipName = clipPath.split("/")[clipPath.split("/").length - 1];
            clipName = clipName.substring(0, clipName.lastIndexOf('.'));
            System.out.println("Adding clip: " + clipPath);
            Clip clip = new VideoClip(clipName, clipPath);
            video.addClip(clip);
            video.addOrder(video.getOrder().size(), clip.hashCode() + "");
        }
    }
}
