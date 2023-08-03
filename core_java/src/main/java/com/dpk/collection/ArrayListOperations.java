package com.dpk.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListOperations {
    public static void getSortedList() {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        Collections.sort(list, Comparator.reverseOrder());
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("ArrayList in desc order: " + list);
    }

    public static void main(String[] args) {
        getSortedList();
    }
}
