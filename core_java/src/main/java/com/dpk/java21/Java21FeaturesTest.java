package com.dpk.java21;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class Java21FeaturesTest {

    /**
     * 1. SequenceCollection feature
     */
    public static void testSequencedList() {
        SequencedCollection<Integer> sequencedList = new ArrayList<>();
        sequencedList.addFirst(5);
        sequencedList.addFirst(4);
        sequencedList.addFirst(3);
        sequencedList.addLast(6);

        System.out.println("Printing items of sequenceList");
        sequencedList.stream().forEach(System.out::println);
    }

    /**
     * 2. RecordPattern enhancement
     */
    public static void testRecordPattern(Object obj) {
        System.out.println("Record Pattern test");
        if(obj instanceof Numbers(int x, int y)) {
            System.out.println("Sum=" + (x + y));
        }
    }
    record Numbers(int x, int y){ }

    /**
     * 3. Switch Pattern
     */
    public static void testSwitchPatternMatching(Object obj) {
        System.out.println("Test switch pattern");
        switch (obj) {
            case Integer i -> System.out.println("Case for integer, value=" + i);

            case Double d -> System.out.println("Case for double, value=" + d);

            default -> System.out.println("Default case");
        }
    }

    public static void main(String[] args) {
        testSequencedList();
        testRecordPattern(new Numbers(2, 3));

        testSwitchPatternMatching(5);
        testSwitchPatternMatching(8.4);
    }
}
