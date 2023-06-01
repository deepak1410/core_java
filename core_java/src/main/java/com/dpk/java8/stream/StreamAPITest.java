package com.dpk.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPITest {

    public static void findDuplicates() {
        int[] arr = {1, 2, 3, 2, 4, 5, 3,  6, 7};

        List<Integer> unique = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(each -> each.getValue() > 1)
                .map(each -> each.getKey())
                .collect(Collectors.toList());

        unique.stream().forEach(System.out::println);
    }

    public static void findOccurrenceOfCharacter() {
        String str = "geeksforgeeks";
        char c = 'e';
        long count = str.chars()
                .filter(each -> each == c)
                .count();
        System.out.println("count=" + count);

    }


    public static void main(String[] args) {
        findOccurrenceOfCharacter();

    }
}
