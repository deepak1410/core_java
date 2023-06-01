package com.dpk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i< n; i++) {
            String line = scanner.nextLine();
            //System.out.println(line);
            checkMatch(line);
        }*/

        checkMatch("i love hackerrank");
        checkMatch("hackerrank is an awesome place for programmers");
        checkMatch("hackerrank");
        checkMatch("i think hackerrank is a great place to hangout");
    }

    private static void checkMatch(String line) {
        System.out.println("hacker".length());

        String startWith = "^(hackerrank).+";
        String endsWith = ".+(hackerrank)$";
        String startEndWith = "^(hackerrank)$";

        if(line.matches(startWith)) {
            System.out.println("1");
        } else if(line.matches(endsWith)) {
            System.out.println("2");
        } else if(line.matches(startEndWith)) {
            System.out.println("0");
        } else {
            System.out.println("-1");
        }

    }


}