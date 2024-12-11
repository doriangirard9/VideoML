package org.videoML.videoml.grammar;

import org.videoML.kernel.Video;
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
    public void enterDeclaration(VideoMLParser.DeclarationContext ctx) {
        System.out.println("Project name is : " + ctx.name.getText());
        video.setName(ctx.name.getText());
    }


    @Override
    public void enterSource(VideoMLParser.SourceContext ctx) {
        System.out.println("Source name is : " + ctx.name.getText());
        System.out.println("Source path is : " + ctx.path.getText());
    }
}
