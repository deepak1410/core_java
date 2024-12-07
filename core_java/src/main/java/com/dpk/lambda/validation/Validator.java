package com.dpk.lambda.validation;

public class Validator {

    private final ValidationStrategy strategy;
    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    private static boolean isValid(String text, String regEx) {
        return new Validator((String s) -> s.matches(regEx)).validate(text);
    }

    public static boolean isAllLowerCase(String text) {
        return isValid(text, "[a-z]+");
    }

    public static boolean isNumeric(String text) {
        return isValid(text, "\\d+");
    }

    public static void main(String[] args) {
        boolean lowerCase = isAllLowerCase("test");
        System.out.println(lowerCase);
    }
}
