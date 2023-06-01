package com.dpk.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamAPITester {

    public static void getSum() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1st argument, init value = 0
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        System.out.println("sum : " + sum); // 55

        sum = Arrays.stream(numbers).sum();
        System.out.println("sum : " + sum); // 55

        double average = Arrays.stream(numbers).boxed().collect(Collectors.averagingInt(Integer::intValue));
        sum = Arrays.stream(numbers).boxed().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Average=" + average + " and sum=" + sum);

        int max = Arrays.stream(numbers).boxed().collect(Collectors.maxBy(Comparator.comparingInt(Integer::intValue))).get();
        System.out.println("max = " + max);
    }

    public static void main(String[] args) {
        getSum();
    }
}
