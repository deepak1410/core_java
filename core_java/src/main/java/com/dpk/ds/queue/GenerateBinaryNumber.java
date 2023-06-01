package com.dpk.ds.queue;

import java.util.Arrays;

public class GenerateBinaryNumber {

    public static String[] generateNumbers(int maxSize) {
        String[] result = new String[maxSize];

        Queue<String> queue1 = new Queue<>(maxSize + 1);
        queue1.enqueue("1");
        for(int i=0; i< maxSize; i++) {
            String item = queue1.dequeue();
            result[i] = item;

            queue1.enqueue(item + "0");
            queue1.enqueue(item + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        String[] result = generateNumbers(10);
        Arrays.stream(result).forEach(System.out::println);
    }
}
