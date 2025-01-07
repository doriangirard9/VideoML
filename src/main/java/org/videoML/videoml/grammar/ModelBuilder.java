package org.videoML.videoml.grammar;

import org.videoML.kernel.Video;
import org.videoML.kernel.Caption;

import org.videoML.kernel.clips.CutClip;
import org.videoML.kernel.clips.VideoClip;
import org.videoML.videoml.grammar.exceptions.VideoExtensionException;
import org.videoML.videoml.grammar.exceptions.VideoTimeException;
import org.videoML.videoml.grammar.helpers.VideoHelper;
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

        if (!VideoHelper.checkExtension(sourcePath)) {
            throw new VideoExtensionException(VideoExtensionException.buildMessage(sourcePath));
        }

        String startTime = ctx.time(0).getText();
        String endTime = ctx.time(1).getText();

        if (!VideoHelper.checkTime(sourcePath, startTime, endTime)) {
            throw new VideoTimeException(VideoTimeException.buildMessage(sourcePath, startTime, endTime));
        }

        String name = ctx.IDENTIFIER().getText();

        System.out.println("Cutting clip: " + sourcePath + " from " + startTime + " to " + endTime + " as " + name);
        CutClip cutClip = new CutClip(name, sourcePath, startTime, endTime);
        video.addTimelineElement(cutClip);
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
        video.addTimelineElement(caption);
    }

    @Override
    public void enterCombine(VideoMLParser.CombineContext ctx) {
        System.out.println("Combining clips...");
        for (int i = 0; i < ctx.STRING().size(); i++) {
            String clipPath = ctx.STRING(i).getText().replace("\"", "");

            if (!VideoHelper.checkExtension(clipPath)) {
                throw new VideoExtensionException(VideoExtensionException.buildMessage(clipPath));
            }


            String clipName = clipPath.split("/")[clipPath.split("/").length - 1];
            clipName = clipName.substring(0, clipName.lastIndexOf('.'));
            System.out.println("Adding clip: " + clipPath);
            VideoClip clip = new VideoClip(clipName, clipPath);
            video.addTimelineElement(clip);
        }
    }

    @Override
    public void enterStack(VideoMLParser.StackContext ctx) {
        String foregroundVideo = ctx.STRING(0).getText().replace("\"", "");
        String backgroundVideo = ctx.STRING(1).getText().replace("\"", "");
        String position1 = ctx.position(0) != null ? ctx.position(0).getText() : "center";
        String position2 = ctx.position(1) != null ? ctx.position(1).getText() : "center";
        double scale = ctx.FLOAT() != null ? Double.parseDouble(ctx.FLOAT().getText()) : 1.0;

        System.out.printf(
                "Stacking clip: %s on %s at (%s, %s) with scale %f",
                foregroundVideo, backgroundVideo, position1, position2, scale
        );

        VideoClip backgroundClip = new VideoClip("background", backgroundVideo);
        video.addTimelineElement(backgroundClip);
        
        VideoClip foregroundClip = new VideoClip("foreground", foregroundVideo);
        foregroundClip.setPosition(position1, position2);
        foregroundClip.setScale(scale);
        foregroundClip.setStartTime(String.format("%s.start", backgroundClip.getName()));
        video.addTimelineElement(foregroundClip);
    }

    @Override
    public void enterTransition(VideoMLParser.TransitionContext ctx) {
        String effectName = ctx.STRING().getText().replace("\"", "");
        String clipName = ctx.IDENTIFIER().getText();
        int duration = Integer.parseInt(ctx.time().getText().replace("s", ""));

        System.out.printf(
                "Applying transition: %s on clip %s with duration %d seconds%n",
                effectName, clipName, duration
        );

        video.addTransition(clipName, effectName, duration);
    }

    @Override
    public void enterFreeze(VideoMLParser.FreezeContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();

        String timer = ctx.start.getText().replace("s", "");
        String duration = ctx.effect_duration.getText().replace("s", "");

        System.out.printf(
                "Freezing clip: %s at timer %s for %s seconds%n",
                clipName, timer, duration
        );

        video.addFreeze(Integer.parseInt(timer), Integer.parseInt(duration), clipName);
    }

    @Override
    public void enterRotate(VideoMLParser.RotateContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        int angle = Integer.parseInt(ctx.NUMBER().getText());

        System.out.printf(
                "Rotating clip: %s with angle %d%n",
                clipName, angle
        );

        video.addRotate(clipName, angle);
    }

    @Override
    public void enterBlur(VideoMLParser.BlurContext ctx) {
        // TODO! NOT YET IMPLEMENTED
        return;
    }

    @Override
    public void enterResize(VideoMLParser.ResizeContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        int scale;
        int width;
        int height;

        if (ctx.percentage() != null) {
            scale = Integer.parseInt(ctx.percentage().getText().replace("%", ""));
            width = -1;
            height = -1;
        }
        else {
            width = Integer.parseInt(ctx.dimensions().width.getText());
            height = Integer.parseInt(ctx.dimensions().height.getText());
            scale = -1;
        }

        System.out.printf(
                "Resizing clip: %s with scale %d%n",
                clipName, scale
        );

        video.addResize(clipName, width, height, scale);
    }

    @Override
    public void enterSlow(VideoMLParser.SlowContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        double factor = Double.parseDouble(ctx.percentage().NUMBER().getText().replace("%", ""));

        System.out.println("Entering slow for clip: " + clipName + " with factor: " + factor);

        System.out.printf(
                "Slowing down clip: %s with value %f%n",
                clipName, factor
        );

        video.addSpeedChanger(clipName, factor, false);
    }

    @Override
    public void enterAccelerate(VideoMLParser.AccelerateContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        double factor = Double.parseDouble(ctx.percentage().NUMBER().getText());

        System.out.println("Entering accelerate for clip: " + clipName + " with factor: " + factor);

        System.out.printf(
                "Speeding up clip: %s with value %f%n",
                clipName, factor
        );

        video.addSpeedChanger(clipName, factor, true);
    }
}
