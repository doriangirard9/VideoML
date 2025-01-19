package org.videoML.videoml.grammar;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.*;

import java.util.*;
import java.util.stream.Collectors;

public class StopErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {

        List<String> ruleNames = Arrays.asList(recognizer.getRuleNames());

        StringBuilder errorMessage = new StringBuilder();
        errorMessage
                .append("\n")
                .append("Syntaxic error. Line ")
                .append(line)
                .append(":")
                .append(charPositionInLine)
                .append(" ")
                .append(msg);

        if (e instanceof InputMismatchException) {
            Token offendingToken = ((InputMismatchException) e).getOffendingToken();
            String mismatched = offendingToken.getText();
            if (mismatched != null) {
                errorMessage.append("\nMismatched input: '").append(mismatched).append("'.");
                boolean useExpected = false;

                List<String> expectedTokens = ((InputMismatchException) e).getExpectedTokens().toList().stream()
                        .map(recognizer.getVocabulary()::getDisplayName)
                        .collect(Collectors.toList());
                System.out.println(expectedTokens);

                if (expectedTokens.size() == 1 && !"EOF".equals(expectedTokens.get(0))) {
                    errorMessage.append("\nYou probably meant: '").append(expectedTokens.get(0)).append("'.");
                    useExpected = true;
                } else if (expectedTokens.size() > 1) {
                    errorMessage.append("\nExpected one of: ").append(String.join(", ", expectedTokens)).append(".");
                    useExpected = true;
                }

                if (!useExpected) {
                    List<String> suggestions = findSimilarRules(mismatched, ruleNames);
                    if (!suggestions.isEmpty()) {
                        errorMessage.append("\nDid you mean: ").append(String.join(", ", suggestions)).append("?");
                    }
                }
            }
        }

        ParseCancellationException ex = new ParseCancellationException(errorMessage.toString());
        ex.setStackTrace(new StackTraceElement[0]);
        throw ex;
    }

    private List<String> findSimilarRules(String input, List<String> ruleNames) {
        return ruleNames.stream()
                .sorted(Comparator.comparingInt(rule -> levenshteinDistance(input, rule)))
                .limit(2)
                .collect(Collectors.toList());
    }

    private int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                    );
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
