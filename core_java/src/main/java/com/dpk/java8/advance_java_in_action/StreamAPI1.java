package com.dpk.java8.advance_java_in_action;

import com.dpk.java8.java8inactionbook.model.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamAPI1 {
    private static List<Dish> specialMenu = Data.specialMenu;

    /* Filter data using predicate provided. It breaks the loop when non-matching data found
    * This is useful when the data was already sorted */
    public static List<Dish> takeWhileElements() {
        return specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320).collect(toList());
    }

    /* Filter data using predicate provided. It breaks the loop when matching data found
     * This is complement to takeWhile. This is useful when the data was already sorted */
    public static List<Dish> dropWhileElements() {
        return specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320).collect(toList());
    }

    public static void test() {
        specialMenu.stream().collect(Collectors.groupingBy(dish -> dish.getType(), Collectors.mapping(d -> d.getName(), toList())));
    }


    public static void main(String[] args) {

    }
}
