package org.videoML.videoml.grammar;

import java.util.ArrayList;
import java.util.List;

import org.videoML.kernel.Video;
import org.videoML.kernel.clips.video.*;
import org.videoML.kernel.effects.video.*;

import org.videoML.videoml.grammar.exceptions.AudioExtensionException;
import org.videoML.videoml.grammar.exceptions.PreviewException;
import org.videoML.videoml.grammar.exceptions.VideoExtensionException;
import org.videoML.videoml.grammar.exceptions.VideoTimeException;
import org.videoML.videoml.grammar.helpers.AudioHelper;
import org.videoML.videoml.grammar.helpers.VideoHelper;
import org.videoML.kernel.clips.video.CompositeVideoClip;
import org.videoML.kernel.clips.video.CutVideoClip;
import org.videoML.kernel.clips.video.TextClip;
import org.videoML.kernel.clips.video.VideoClip;
import org.videoML.kernel.clips.audio.AudioClip;
import org.videoML.kernel.clips.audio.CompositeAudioClip;

import videoml.grammar.VideoMLBaseListener;
import videoml.grammar.VideoMLParser;


public class ModelBuilder extends VideoMLBaseListener {
    private Video video = null;
    private boolean built = false;

    private String getVideoClipNameFromPath(String path) {
        if (!VideoHelper.isValidExtension(path)) {
            throw new VideoExtensionException(VideoExtensionException.buildMessage(path));
        }

        return String.format("VideoFileClip(\"%s\")", path);
    }

    private String getAudioClipNameFromPath(String path) {
        if (!AudioHelper.isValidExtension(path)) {
            throw new AudioExtensionException(AudioExtensionException.buildMessage(path));
        }

        return String.format("AudioFileClip(\"%s\")", path);
    }


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
        
        if (ctx.NUMBER() != null) {
            int fps = Integer.parseInt(ctx.NUMBER().getText());
            video.setFps(fps);
        }

        if (ctx.dimensions() != null) {
            int width = Integer.parseInt(ctx.dimensions().width.getText());
            int height = Integer.parseInt(ctx.dimensions().height.getText());
            video.setWidth(width);
            video.setHeight(height);
        }
    }

    @Override
    public void enterAdd(VideoMLParser.AddContext ctx) {
        for (int i = 0; i < ctx.video().size(); i++) {
            String clipPath = ctx.video(i).STRING().getText().replace("\"", "");

            String clipName;
            if (ctx.video(i).IDENTIFIER() != null)
                clipName = ctx.video(i).IDENTIFIER().getText();
            else
                clipName = video.generateClipName();

            VideoClip clip = new VideoClip(clipName, getVideoClipNameFromPath(clipPath));
            video.addTimelineElement(clip);
            System.out.println(clip.getParent());
            System.out.println("Adding clip: " + clipPath + " with name " + clip.getName());
        }
    }

    @Override
    public void enterCut(VideoMLParser.CutContext ctx) {
        String clipName;
        if (ctx.name != null)
            clipName = ctx.name.getText();
        else
            clipName = video.generateClipName();

        String targetName;
        String targetClipPath = "";
        // Path to a clip
        if (ctx.variable().STRING() != null) {
            targetClipPath = ctx.variable().STRING().getText().replace("\"", "");
            targetName = getVideoClipNameFromPath(targetClipPath);
        }
        // VideoClip variable
        else {
            targetName = ctx.variable().IDENTIFIER().getText();
        }

        CutVideoClip cutVideoClip = new CutVideoClip(clipName, targetName);

        String startTime = ctx.time(0).getText();
        String endTime = ctx.time(1).getText();
        cutVideoClip.setStart(startTime);
        cutVideoClip.setEnd(endTime);

        if (!targetClipPath.isEmpty() && !VideoHelper.isValidTiming(targetClipPath, startTime, endTime)) {
            throw new VideoTimeException(VideoTimeException.buildMessage(targetClipPath, startTime, endTime));
        }

        System.out.println("Cutting clip: " + cutVideoClip.getSource() + " from " + startTime + " to " + endTime + " as " + cutVideoClip.getName());
        video.addTimelineElement(cutVideoClip);
    }

    @Override
    public void enterCaption(VideoMLParser.CaptionContext ctx) {
        String text = ctx.STRING().getText().replace("\"", "");

        String clipName = null;
        if (ctx.IDENTIFIER() != null)
            clipName = ctx.IDENTIFIER().getText();
        else
            clipName = video.generateClipName();
        TextClip caption = new TextClip(clipName);

        caption.setText(text);

        // tied to a clip
        if (ctx.offset() != null) {
            String targetClipName = null;

            // VideoClip variable
            if (ctx.offset().variable().IDENTIFIER() != null)
                targetClipName = ctx.offset().variable().IDENTIFIER().getText();
            // VideoClip path
            else {
                String targetClipPath = ctx.offset().variable().STRING().getText().replace("\"", "");
                VideoClip targetClip = new VideoClip(video.generateClipName(), getVideoClipNameFromPath(targetClipPath));
                video.addTimelineElement(targetClip);
                targetClipName = targetClip.getName();
            }
            caption.setTargetClip(targetClipName);

            // delay
            if (ctx.offset().time() != null) {
                int delay = Integer.parseInt(ctx.offset().time().getText().replace("s", ""));
                caption.setDelay(delay);
            }

            // duration
            if (ctx.offset().duration() != null) {
                int duration = Integer.parseInt(ctx.offset().duration().time().getText().replace("s", ""));
                caption.setDuration(duration);
            }
        }
        else {
            int duration = Integer.parseInt(ctx.duration().time().getText().replace("s", ""));
            caption.setDuration(duration);
        }

        String position1 = ctx.position(0) != null ? ctx.position(0).getText() : "center";
        String position2 = ctx.position(1) != null ? ctx.position(1).getText() : "center";
        caption.setPosition(position1, position2);

        System.out.printf(
                "Adding caption %s: %s on clip %s with %d seconds delay and for %d seconds\n",
                clipName, text, caption.getTargetClip(), caption.getDelay(), caption.getDuration()
        );
        video.addTimelineElement(caption);
    }

    @Override
    public void enterImage(VideoMLParser.ImageContext ctx) {
        String imagePath = ctx.STRING().getText().replace("\"", "");

        String clipName = null;
        if (ctx.IDENTIFIER() != null)
            clipName = ctx.IDENTIFIER().getText();
        else
            clipName = video.generateClipName();
        
        ImageClip imageClip = new ImageClip(clipName);
        imageClip.setSource(imagePath);

        // tied to a clip
        if (ctx.offset() != null) {
            String targetClipName = null;

            // VideoClip variable
            if (ctx.offset().variable().IDENTIFIER() != null)
                targetClipName = ctx.offset().variable().IDENTIFIER().getText();
            // VideoClip path
            else {
                String targetClipPath = ctx.offset().variable().STRING().getText().replace("\"", "");
                VideoClip targetClip = new VideoClip(video.generateClipName(), getVideoClipNameFromPath(targetClipPath));
                video.addTimelineElement(targetClip);
                targetClipName = targetClip.getName();
            }
            imageClip.setTargetClip(targetClipName);

            // delay
            if (ctx.offset().time() != null) {
                int delay = Integer.parseInt(ctx.offset().time().getText().replace("s", ""));
                imageClip.setDelay(delay);
            }

            // duration
            if (ctx.offset().duration() != null) {
                int duration = Integer.parseInt(ctx.offset().duration().time().getText().replace("s", ""));
                imageClip.setDuration(duration);
            }
        }
        else {
            int duration = Integer.parseInt(ctx.duration().time().getText().replace("s", ""));
            imageClip.setDuration(duration);
        }

        String position1 = ctx.position(0) != null ? ctx.position(0).getText() : "center";
        String position2 = ctx.position(1) != null ? ctx.position(1).getText() : "center";
        imageClip.setPosition(position1, position2);

        System.out.printf(
                "Adding image %s with path %s on clip %s with %d seconds delay and for %d seconds\n",
                clipName, imagePath, imageClip.getTargetClip(), imageClip.getDelay(), imageClip.getDuration()
        );
        video.addTimelineElement(imageClip);
    }

    @Override
    public void enterCombine(VideoMLParser.CombineContext ctx) {
        String compositeClipName = ctx.IDENTIFIER().getText();
        boolean isAudio = false; 
        
        // Check if the first clip is an audio clip
        if (ctx.variable(0).STRING() != null) {
            String firstClipPath = ctx.variable(0).STRING().getText().replace("\"", "");
            if (AudioHelper.isValidExtension(firstClipPath)) {
                isAudio = true;
            }
        }

        if (!isAudio) {
            CompositeVideoClip compositeClip = new CompositeVideoClip(compositeClipName);
            for (int i = 0; i < ctx.variable().size(); i++) {
                VideoClip videoClip = null;
                // Path to a clip, so we need to generate the clip
                if (ctx.variable(i).STRING() != null) {
                    String clipPath = ctx.variable(i).STRING().getText().replace("\"", "");
                    videoClip = new VideoClip(video.generateClipName(), getVideoClipNameFromPath(clipPath));
                    video.addTimelineElement(videoClip);
                }
                else {
                    String clipName = ctx.variable(i).IDENTIFIER().getText();
                    videoClip = video.getVideoClip(clipName);
                }
                compositeClip.addClip(videoClip);
                videoClip.setParent(compositeClipName);
            }
            video.addCombineClip(compositeClipName);
            video.addTimelineElement(compositeClip);
        } else {
            CompositeAudioClip compositeClip = new CompositeAudioClip(compositeClipName);
            String clipNameGenerated;
            List<String> clipNames = new ArrayList<>();
            
            for (int i = 0; i < ctx.variable().size(); i++) {
                AudioClip audioClip = null;
                if (ctx.variable(i).STRING().getText() != null) {
                    String clipPath = ctx.variable(i).STRING().getText().replace("\"", "");
                    clipNameGenerated = video.generateClipName();
                    clipNames.add(clipNameGenerated);
                    audioClip = new AudioClip(clipNameGenerated, getAudioClipNameFromPath(clipPath), clipPath);
                    
                    if (i == 0) {
                        audioClip.setPreceededBy(String.format("0", compositeClipName));
                    }

                    else {
                        audioClip.setPreceededBy(String.format("%s.end", compositeClip.getAudioClips().get(i - 1).getName()));
                    }
                    video.addTimelineElement(audioClip);
                    clipNames.add(clipNameGenerated);
                }
                else {
                    String clipName = ctx.variable(i).IDENTIFIER().getText();
                    audioClip = video.getAudioClip(clipName);
                    clipNames.add(clipName);
                }
                compositeClip.addAudioClip(audioClip);
                audioClip.setParent(compositeClipName);
            }
            video.addTimelineElement(compositeClip);
        }
    }

    @Override
    public void enterAdjustVolume(VideoMLParser.AdjustVolumeContext ctx) {
        boolean hasSetVolume = false;
        String audioClipPath = ctx.variable().STRING().getText().replace("\"", "").trim();
        int volume = Integer.parseInt(ctx.percentage().getText().replace("%", ""));
        
        for (int i = 0; i < video.getTimeline().size(); i++) {
            if (video.getTimeline().get(i) instanceof AudioClip) {
                AudioClip audioClip = (AudioClip) video.getTimeline().get(i);
                if (audioClip.getPath() != null) {
                    if (audioClip.getPath().equals(audioClipPath)) {
                        audioClip.setVolume(volume / 100.0);
                        hasSetVolume = true;
                        break;
                    }
                }
            }
        }

        if (!hasSetVolume) {
            RuntimeException e = new RuntimeException("Audio clip not found: " + audioClipPath + ". Cannot adjust volume.");
            e.setStackTrace(new StackTraceElement[0]);
            throw e;
        }

        System.out.printf("Adjusting volume of clip %s to %f%n", audioClipPath, volume);
    }

    @Override
    public void enterOverlay(VideoMLParser.OverlayContext ctx) {
        
        AudioClip audioClip;
        VideoClip targetVideoClip;
        String targetName;

        // Video part 
        if (ctx.variable(1).STRING() != null) {
            String targetClipPath = ctx.variable(1).STRING().getText().replace("\"", "");
            targetName = getVideoClipNameFromPath(targetClipPath);
            targetVideoClip = new VideoClip(video.generateClipName(), targetName);
            video.addTimelineElement(targetVideoClip);
        } else {
            String existingVidName = ctx.variable(1).IDENTIFIER().getText();
            targetVideoClip = video.getVideoClip(existingVidName);
            if (targetVideoClip == null) {
                System.err.println("Video clip not found: " + existingVidName);
                return;
            }
        }
        
        // Audio File 
        if (ctx.variable(0).IDENTIFIER() == null) {
            String clipPath = ctx.variable(0).STRING().getText().replace("\"", "");
            String clipNameGenerated = video.generateClipName();
            audioClip = new AudioClip(clipNameGenerated, getAudioClipNameFromPath(clipPath), clipPath);
            audioClip.setAssociatedVideoClip(targetVideoClip.getName());
            audioClip.setEndTime(targetVideoClip.getName() + ".end");
            video.addTimelineElement(audioClip);
        } else {
            String audioVarName = ctx.variable(0).IDENTIFIER().getText();
            audioClip = video.getAudioClip(audioVarName);
            audioClip.setAssociatedVideoClip(targetVideoClip.getName());
        }
        
        if (audioClip.getPreceededBy() == null) {
            audioClip.setPreceededBy(String.format("%s.start", targetVideoClip.getName()));
        }

        
        if (ctx.fromAudioTime() != null) {
            String startVal = ctx.fromAudioTime().time(0).getText(); 
            String lengthVal = ctx.fromAudioTime().time(1).getText(); 

            int startSeconds  = Integer.parseInt(startVal.replace("s", ""));
            int lengthSeconds = Integer.parseInt(lengthVal.replace("s", ""));
            int endSeconds    = startSeconds + lengthSeconds;

            audioClip.setStartTime(startVal);             
            audioClip.setEndTime(endSeconds + "s");      
        }

        
        if (ctx.fromVideoTime() != null) {
            String startVal = ctx.fromVideoTime().time(0).NUMBER().getText();  
            String lengthVal = ctx.fromVideoTime().time(1).NUMBER().getText();

            int startSeconds  = Integer.parseInt(startVal);
            int lengthSeconds = Integer.parseInt(lengthVal);
            int endSeconds    = startSeconds + lengthSeconds;

            audioClip.setOnOverlayStart(targetVideoClip.getName() + ".start+" + startVal);
            audioClip.setOnOverlayEnd(targetVideoClip.getName() + ".start+" + endSeconds);
        } else {
            audioClip.setOnOverlayStart(targetVideoClip.getName() + ".start");
            audioClip.setOnOverlayEnd(targetVideoClip.getName() + ".end");
        }
    }

    @Override
    public void enterStack(VideoMLParser.StackContext ctx) {
        // background clip
        VideoClip backgroundClip = null;
        if (ctx.variable(1).STRING() != null) {
            String clipPath = ctx.variable(1).STRING().getText().replace("\"", "");
            backgroundClip = new VideoClip(video.generateClipName(), getVideoClipNameFromPath(clipPath));
            video.addTimelineElement(backgroundClip);
        }
        else {
            String clipName = ctx.variable(1).IDENTIFIER().getText();
            backgroundClip = video.getVideoClip(clipName);
        }

        // foreground clip
        VideoClip foregroundClip = null;
        if (ctx.variable(0).STRING() != null) {
            String clipPath = ctx.variable(0).STRING().getText().replace("\"", "");
            foregroundClip = new VideoClip(video.generateClipName(), getVideoClipNameFromPath(clipPath));
            video.addTimelineElement(foregroundClip);
        }
        else {
            String clipName = ctx.variable(0).IDENTIFIER().getText();
            foregroundClip = video.getVideoClip(clipName);
        }

        String position1 = ctx.position(0) != null ? ctx.position(0).getText() : "center";
        String position2 = ctx.position(1) != null ? ctx.position(1).getText() : "center";
        double scale = ctx.FLOAT() != null ? Double.parseDouble(ctx.FLOAT().getText()) : 1.0;

        System.out.printf(
                "Stacking clip: %s on %s at (%s, %s) with scale %f",
                foregroundClip.getName(), backgroundClip.getName(), position1, position2, scale
        );
        
        foregroundClip.setPosition(position1, position2);
        Resize foregroundClipResize = new Resize(scale, foregroundClip.getName());
        foregroundClip.addEffect(foregroundClipResize);
        foregroundClip.setStartTime(String.format("%s.start", backgroundClip.getName()));
    }

    @Override
    public void enterPreview(VideoMLParser.PreviewContext ctx) {
        String clipName = ctx.IDENTIFIER() != null ? ctx.IDENTIFIER().getText() : null;
        PreviewClip previewClip = new PreviewClip(clipName);
        video.addTimelineElement(previewClip);
        video.setPreview(true);
        this.built = true;
        throw new PreviewException("Previewing the video so skipping the rest of the parsing");
    }

    @Override
    public void enterResize(VideoMLParser.ResizeContext ctx) {
        Resize resizeEffect = null;

        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);

        if (ctx.percentage() != null) {
            double scale = Double.parseDouble(ctx.percentage().NUMBER().getText().replace("%", ""));
            resizeEffect = new Resize(scale / 100, clipName);
        }
        else {
            int width = Integer.parseInt(ctx.dimensions().width.getText());
            int height = Integer.parseInt(ctx.dimensions().height.getText());
            resizeEffect = new Resize(width, height, clipName);
        }

        videoClip.addEffect(resizeEffect);
    }

    @Override
    public void enterTransition(VideoMLParser.TransitionContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);
        Transition transition = null;
        int duration = Integer.parseInt(ctx.time().getText().replace("s", ""));

        if (ctx.fadeIn != null)
            transition = new Transition(TransitionType.FADEIN, duration, clipName);
        else if (ctx.fadeOut != null)
            transition = new Transition(TransitionType.FADEOUT, duration, clipName);
        else if (ctx.crossFadeIn != null)
            transition = new Transition(TransitionType.CROSSFADEIN, duration, clipName);
        else 
            transition = new Transition(TransitionType.CROSSFADEOUT, duration, clipName);

        videoClip.addEffect(transition);
    }

    @Override
    public void enterRotate(VideoMLParser.RotateContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);

        int angle = Integer.parseInt(ctx.NUMBER().getText());
        Rotate rotateEffect = new Rotate(angle, clipName);

        System.out.printf(
                "Rotating clip: %s with angle %d%n",
                clipName, angle
        );

        videoClip.addEffect(rotateEffect);
    }

    @Override
    public void enterAccelerate(VideoMLParser.AccelerateContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);
        double factor = Double.parseDouble(ctx.percentage().NUMBER().getText());
        SpeedChanger speedChanger = new SpeedChanger(clipName, factor, true);

        System.out.printf("Speeding up clip: %s with value %f%n", clipName, factor);
        videoClip.addEffect(speedChanger);
    }

    @Override
    public void enterSlow(VideoMLParser.SlowContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);
        double factor = Double.parseDouble(ctx.percentage().NUMBER().getText());
        SpeedChanger speedChanger = new SpeedChanger(clipName, factor, false);

        System.out.printf("Slowing down clip: %s with value %f%n", clipName, factor);
        videoClip.addEffect(speedChanger);
    }

    @Override
    public void enterFreeze(VideoMLParser.FreezeContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);

        String timer = ctx.start.getText().replace("s", "");
        String duration = ctx.effect_duration.getText().replace("s", "");

        Freeze freeze = new Freeze(Integer.parseInt(timer), Integer.parseInt(duration), clipName);

        System.out.printf(
                "Freezing clip: %s at timer %s for %s seconds%n",
                clipName, timer, duration
        );

        videoClip.addEffect(freeze);
    }

    @Override
    public void enterCrop(VideoMLParser.CropContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);
        int x1, y1, x2, y2;

        if (ctx.cropOptions().all != null) {
            x1 = Integer.parseInt(ctx.cropOptions().all.getText().replace("%", ""));
            y1 = x1;
            x2 = x1;
            y2 = x1;
        }
        else if (ctx.cropOptions().topBottom != null) {
            x1 = Integer.parseInt(ctx.cropOptions().leftRight.getText().replace("%", ""));
            y1 = Integer.parseInt(ctx.cropOptions().topBottom.getText().replace("%", ""));
            x2 = x1;
            y2 = y1;
        }
        else {
            x1 = Integer.parseInt(ctx.cropOptions().left.getText().replace("%", ""));
            y1 = Integer.parseInt(ctx.cropOptions().top.getText().replace("%", ""));
            x2 = Integer.parseInt(ctx.cropOptions().right.getText().replace("%", ""));
            y2 = Integer.parseInt(ctx.cropOptions().bottom.getText().replace("%", ""));
        }

        System.out.printf(
                "Cropping clip: %s from (%d, %d) to (%d, %d)\n",
                clipName, x1, y1, x2, y2
        );

        Crop cropEffect = new Crop(clipName, x1, y1, x2, y2);
        videoClip.addEffect(cropEffect);
    }

    public void enterGreenScreen(VideoMLParser.GreenScreenContext ctx) {
        String clipName = ctx.IDENTIFIER().getText();
        VideoClip videoClip = video.getVideoClip(clipName);

        GreenScreen greenScreen = null;

        if (ctx.NUMBER() != null) {
            int threshold = Integer.parseInt(ctx.NUMBER().getText());
            greenScreen = new GreenScreen(threshold, clipName);
        }
        else 
            greenScreen = new GreenScreen(clipName);

        videoClip.addEffect(greenScreen);
    }
}