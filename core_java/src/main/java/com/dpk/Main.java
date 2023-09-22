package com.dpk;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int x = 100;
        IntStream.rangeClosed(2, (int)Math.sqrt(x))
                .noneMatch(i -> x % i == 0);


    }

}
