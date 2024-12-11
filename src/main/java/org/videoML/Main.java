package org.videoML;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.videoML.kernel.Video;
import org.videoML.kernel.generator.ToWiring;
import org.videoML.kernel.generator.Visitor;
import org.videoML.videoml.grammar.ModelBuilder;
import org.videoML.videoml.grammar.StopErrorListener;
import videoml.grammar.VideoMLLexer;
import videoml.grammar.VideoMLParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\nRunning the ANTLR compiler for VideoML");

        CharStream stream = getCharStream(args);

        Video video = buildModel(stream);
        exportToCode(video);
    }

    private static CharStream getCharStream(String[] args) throws IOException {
        if (args.length < 1)
            throw new RuntimeException("no input file");
        Path input = Paths.get(new File(args[0]).toURI());
        System.out.println("Using input file: " + input);
        return CharStreams.fromPath(input);
    }

    private static Video buildModel(CharStream stream) {
        VideoMLLexer    lexer   = new VideoMLLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new StopErrorListener());

        VideoMLParser   parser  = new VideoMLParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new StopErrorListener());

        ParseTreeWalker walker  = new ParseTreeWalker();
        ModelBuilder      builder = new ModelBuilder();

        walker.walk(builder, parser.root()); // parser.root() is the entry point of the grammar

        return builder.retrieve();
    }

    private static void exportToCode(Video video) {
        Visitor codeGenerator = new ToWiring();
        video.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }

}