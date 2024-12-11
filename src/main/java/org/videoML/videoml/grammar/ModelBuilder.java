package org.videoML.videoml.grammar;

import videoml.grammar.VideoMLBaseListener;
import videoml.grammar.VideoMLParser;

public class ModelBuilder extends VideoMLBaseListener {

    @Override
    public void enterRoot(VideoMLParser.RootContext ctx) {
        System.out.println("Entering root");
    }

    @Override
    public void exitRoot(VideoMLParser.RootContext ctx) {
        System.out.println("Exiting root");
    }

    @Override
    public void enterDeclaration(VideoMLParser.DeclarationContext ctx) {
        System.out.println("Project name is : " + ctx.name.getText());
    }


    @Override
    public void enterSource(VideoMLParser.SourceContext ctx) {
        System.out.println("Source name is : " + ctx.name.getText());
        System.out.println("Source path is : " + ctx.path.getText());
    }
}
