package org.videoML.videoml.grammar;

import org.videoML.kernel.Video;
import org.videoML.kernel.Caption;

import org.videoML.kernel.clips.Clip;
import org.videoML.kernel.clips.VideoClip;
import videoml.grammar.VideoMLBaseListener;
import videoml.grammar.VideoMLParser;

public class ModelBuilder extends VideoMLBaseListener {
    private Video video = null;
    private boolean built = false;

    public Video retrieve() {
        if (built) { return video; }
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
    public void enterCaption(VideoMLParser.CaptionContext ctx) {
        String text = ctx.STRING().getText().replace("\"", "");
        int duration = Integer.parseInt(ctx.duration().time().getText().replace("s", ""));

        System.out.println("Adding caption: " + text + " for " + duration + " seconds");
        Caption caption = new Caption(text, duration);
        video.addCaption(caption);
    }

    @Override
    public void enterCombine(VideoMLParser.CombineContext ctx) {
        System.out.println("Combining clips...");
        for (int i = 0; i < ctx.STRING().size(); i++) {
            String clipPath = ctx.STRING(i).getText().replace("\"", "");
            String clipName = clipPath.split("/")[clipPath.split("/").length - 1];
            System.out.println("Adding clip: " + clipPath);
            Clip clip = new VideoClip(clipName, clipPath);
            video.addClip(clip);
        }
    }
}
