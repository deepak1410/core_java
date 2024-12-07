package com.dpk.java8.advance_java_in_action;

import com.dpk.java8.java8inactionbook.model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;


public class StreamCollector {
    private static List<Dish> menu = Data.specialMenu;

    // Grouping and filtering
    public void getCaloricDishesByType() {
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
    }

    // Grouping and Mapping
    public void getDishNamesByType() {
        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,
                        mapping(Dish::getName, toList())));
    }

    // Grouping and Max
    public void getMostCaloriesByType() {
        Map<Dish.Type, Optional<Dish>> mostCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        maxBy(Comparator.comparingInt(Dish::getCalories))));

        // Another way
        Map<Dish.Type, Dish> mostCaloriesByType1 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }

    public static void main(String[] args) {

    }


}
