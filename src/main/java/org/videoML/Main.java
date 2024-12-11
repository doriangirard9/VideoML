package org.videoML;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.videoML.videoml.grammar.ModelBuilder;
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

        // print CharStream
        System.out.println("stream : " + stream.toString());

        buildModel(stream);
        // exportToCode(theApp);
    }

    private static CharStream getCharStream(String[] args) throws IOException {
        if (args.length < 1)
            throw new RuntimeException("no input file");
        Path input = Paths.get(new File(args[0]).toURI());
        System.out.println("Using input file: " + input);
        return CharStreams.fromPath(input);
    }

    private static void buildModel(CharStream stream) {
        VideoMLLexer    lexer   = new VideoMLLexer(stream);
        lexer.removeErrorListeners();
        // lexer.addErrorListener(new StopErrorListener());

        VideoMLParser   parser  = new VideoMLParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        // parser.addErrorListener(new StopErrorListener());

        ParseTreeWalker walker  = new ParseTreeWalker();
        ModelBuilder      builder = new ModelBuilder();

        walker.walk(builder, parser.root()); // parser.root() is the entry point of the grammar

        return;
    }

}