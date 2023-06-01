package com.dpk.ds.stack;

public class EvaluatePostfixChallenge {

    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());

        for(Character ch : expression.toCharArray()) {
            if(!Character.isDigit(ch)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = evaluate(ch, num2, num1); // Order of num1 and num2 are changed due to LIFO
                stack.push(result);
            } else {
                stack.push(Character.getNumericValue(ch));
            }



        }
        return stack.pop();
    }

    private static Integer evaluate(Character operator, Integer num1, Integer num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }

        throw new RuntimeException("Invalid operation");
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFix("921*-8-4+"));
    }
}
