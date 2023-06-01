package com.dpk.java8.functional;

import java.util.function.*;

@FunctionalInterface
public interface Animal {
    public void run();
    public static void sleep() {
        System.out.println("The animal is sleeping");
    }

}
