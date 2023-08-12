package com.dpk.java8.java8inactionbook;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1Problems {

    /**
     * Quiz 5.2 : Given a list of numbers, how would you return a list of the square of each number?
     * For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
     */
    public static List<Integer> getListOfSquare() {
        List<Integer> inputList = List.of(1, 2, 3, 4, 5);
        return inputList.stream()
                .map(item -> item * item)
                .collect(Collectors.toList());
    }

    /**
     * Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3]
     * and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
     * Part-2: Return only pairs whose sum are divisible by 3.
     */
    public static List<List<Integer>>  getListOfPairs() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4);

        return list1.stream()
                .flatMap(item1 -> list2.stream()
                        .filter(item2 -> (item1 + item2) % 3 == 0) // Added this for part-2
                        .map(item2 -> List.of(item1, item2)))
                .collect(Collectors.toList());
    }

    /**
     * Quiz 5.3
     * How would you count the number of dishes in a stream using the map and reduce methods
     */
    public static int getDishesCount() {
        List<String> menu = List.of("Sandwich", "Pasta", "Noodle", "Bread");
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println("count = 4 " + (count == 4));
        return count;
    }

    /**
     * Generate Pythagorean up to 100 values
     */
    public static List<int[]> generatePythagorean() {
        return IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 ==0)
                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)})
                )
                .collect(Collectors.toList());

    }

    /**
     * Generate Fibonacci series up to 20 values
     */
    public static List<Integer> generateFibonacci(int count) {
        return Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(count)
                .map(x -> x[0])
                .collect(Collectors.toList());
    }

    /**
     * Check if a number is a prime number
     */
    public static boolean isPrime(int num) {
        int root = (int)Math.sqrt(num); // upper limit
        return IntStream.rangeClosed(2, root)
                .noneMatch(i -> num % i == 0);
    }

    /**
     * Get Number of characters for each words
     */
    public static List<Integer> findWordsLengths() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(Integer::valueOf)
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    /**
     * Find even numbers up to 20
     */
    public static void getEvenNumbers() {
        IntStream.iterate(2, x -> x+2)
                .limit(20)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        getListOfSquare();
        List<List<Integer>> pairs = getListOfPairs();
        getDishesCount();
        List<int[]> pythagorean = generatePythagorean();
        generateFibonacci(20);
    }
}
