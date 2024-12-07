package com.dpk.java8.advance_java_in_action;

import com.dpk.java8.java8inactionbook.model.Dish;

import java.util.List;

public class StreamAPIProblems {
    private static List<Dish> specialMenu = Data.specialMenu;

    public static void getPairs(List<Integer> list1, List<Integer> list2) {
        List<List<Integer>> pairs = list1.stream().flatMap(i1 -> list2.stream().map(i2 -> List.of(i1, i2)))
                .filter(i -> i.stream().reduce(0, Integer::sum) % 3 == 0)
                .toList();
    }

    public static void countDishes() {
        specialMenu.stream().map(menu -> 1).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        //getPairs(List.of(1, 2, 3), List.of(3, 4));
        countDishes();
    }
}
