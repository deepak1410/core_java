package com.dpk.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MostFrequentSubstring {

    public static String findMostFrequent(String str, int n) {
        Map<String, Integer> countMap = new HashMap<>();

        for(int i=0; i<str.length() -n; i++) {
            String substr = str.substring(i, i+n);
            countMap.put(substr, countMap.getOrDefault(substr, 0) + 1);
        }

        // Solution-1
        String val = countMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        // Solution-2
        List<String> list =  countMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        return list.get(0);
    }

    public static String addCommas(String s) {
        return s.chars().mapToObj(Character::toString).collect(Collectors.joining(","));
    }

    public static List<Integer> mergerSortedLists(List<Integer> list1, List<Integer> list2) {
        list1.addAll(list2);
        Collections.sort(list1);
        return list1;
    }


    public static void main(String[] args) {
        String s = "inengineering";
        String mostFrequent = findMostFrequent(s, 2);
        System.out.println(mostFrequent);

        System.out.println("Add commas: " + addCommas(s));

        Map<String, Integer> countMap = new HashMap<>();
        countMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());

        List<Integer> list1 = new ArrayList<>(Arrays.asList(2,3,4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5));

        List<Integer> list3 = mergerSortedLists(list1, list2);

    }
}
