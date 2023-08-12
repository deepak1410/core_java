package com.dpk.java8.java8inactionbook;

import com.dpk.java8.java8inactionbook.model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2CollectingData {

    private static final List<Dish> menu = Dish.getMenu();

    /**
     * Get dish with maximum calorie
     */
    public static Dish getDishWithMaxCalories() {
        return menu.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
                .get();
    }

    /**
     * Get total calories
     */
    public static int getTotalCalories() {
        // Using map
        /*return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();*/

        return menu.stream()
                .collect(Collectors.reducing(0, // Initial value
                        Dish::getCalories, // Transformation function
                        Integer::sum)); // Aggregating function
    }

    /**
     * Group by menu items by classifying as “diet” all dishes with 400 calories or fewer, set to “normal”
     * the dishes having between 400 and 700 calories, and set to “fat” the ones with more than 700 calories.
     */
    public Map<Dish.CaloricLevel, List<Dish>> getDishesByCaloricLevel() {
        return menu.stream()
                .collect(Collectors.groupingBy(
                        dish -> {
                            if(dish.getCalories() < 400) {
                                return Dish.CaloricLevel.DIET;
                            } else if(dish.getCalories() >= 400 && dish.getCalories() < 700) {
                                return Dish.CaloricLevel.NORMAL;
                            } else {
                                return Dish.CaloricLevel.FAT;
                            }
                        }
                ));
    }

    /**
     * Multi-level grouping - Group dishes by types and calories.
     */
    public Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> getDishesByTypeAndCalories() {
        return menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.groupingBy(
                            dish -> {
                                if(dish.getCalories() < 400) {
                                    return Dish.CaloricLevel.DIET;
                                } else if(dish.getCalories() >= 400 && dish.getCalories() < 700) {
                                    return Dish.CaloricLevel.NORMAL;
                                } else {
                                    return Dish.CaloricLevel.FAT;
                                }
                            })
                ));
    }

    /**
     * find the highest-calorie dish in the menu
     */
    public Map<Dish.Type, Optional<Dish>> findHighestCalorieDishInMenu() {
        return menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                ));
    }

    /**
     * find the highest-calorie dish in the menu avoiding Optional as value
     */
    public Map<Dish.Type, Dish> findHighestCalorieDishInMenu2() {
        return menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get
                        )
                ));
    }

    /**
     * Find diet type and calorie level mapping
     */
    public Map<Dish.Type, Set<Dish.CaloricLevel>> findDietTypeAndCalorieLevel() {
        return menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.mapping(
                                dish -> {
                                    if(dish.getCalories() < 400) {
                                        return Dish.CaloricLevel.DIET;
                                    } else if(dish.getCalories() >= 400 && dish.getCalories() < 700) {
                                        return Dish.CaloricLevel.NORMAL;
                                    } else {
                                        return Dish.CaloricLevel.FAT;
                                    }
                                },

                                Collectors.toSet()
                        )
                ));
    }

    /**
     * Get veg and non veg dishes in a map.
     */
    public static Map<Boolean, Set<Dish>> getVegAndNonVegDishes() {
        return menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.toSet()));
    }

    /**
     * Get most caloric dishes partitioned by veg.
     */
    public static Map<Boolean, Dish> mostCaloricPartitionedByVeg() {
        return menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
    }

    /**
     * Find whether numbers are prime numbers or not up to n count.
     */
    public static Map<Boolean, List<Integer>> partitionPrimeNumbers(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(Stream1Problems::isPrime));
    }

    public static void main(String[] args) {

    }
}
