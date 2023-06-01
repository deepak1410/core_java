package com.dpk.lambda;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Java8Function {

    /**
     * Create a function for testing
     */
    public static void executeFunction() {
        Function<String, Integer> func = x -> x.length();
        String text = "Simple String for testing";

        int length = func.apply(text);
        System.out.println("Length of '" + text + "'=" + length);
    }

    public static void executeChainFunction() {
        UnaryOperator<String> trimFunc = x -> x.trim();
        Function<String, Integer> lenFunc = x -> x.length();

        String text = " Hello World! ";

        int length = trimFunc.andThen(lenFunc).apply(text);
        System.out.println("After trimming Length of '" + text + "'=" + length);
    }

    public static Map<String, Integer> getWordLengths(String text) {
        Map<String, Integer> wordLengths = new LinkedHashMap<>();
        String[] words = text.split(" ");

        Function<String, Integer> func = x -> x.length();

        Arrays.stream(words).forEach(word -> {
            wordLengths.put(word, func.apply(word));
        });

        return wordLengths;
    }

    public static void testWordLength() {
        String text = "This is a test String";
        Map<String, Integer> wordLengths = getWordLengths(text);
        for(Map.Entry entry : wordLengths.entrySet()) {
            System.out.println(entry.getKey() + " length=" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        executeFunction();
        executeChainFunction();
        testWordLength();
    }
}
