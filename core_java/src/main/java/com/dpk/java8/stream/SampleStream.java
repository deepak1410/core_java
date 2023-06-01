package com.dpk.java8.stream;

import java.util.Comparator;
import java.util.List;

public class SampleStream {

    public static void findMax() {
        List<Integer> list = List.of(8, 2, 4, 9, 5, 6);
        int max = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
    }


    public static void main(String[] args) {
        findMax();
    }
}
