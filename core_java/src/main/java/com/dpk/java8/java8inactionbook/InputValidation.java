package com.dpk.java8.java8inactionbook;

/**
 * Functional Interface
 */
interface ValidationStrategy {
    boolean execute(String str);
}

class Validator {
    private ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String str) {
        return validationStrategy.execute(str);
    }
}

public class InputValidation {

    public static void main(String[] args) {

        Validator numericValidation = new Validator((String str) -> str.matches("\\d+"));
        boolean isNumeric = numericValidation.validate("aabbcc");

        Validator lowerCaseValidation = new Validator((String str) -> str.matches("[a-z]+"));
        boolean isLowerCase = lowerCaseValidation.validate("aabbcc");
    }
}
