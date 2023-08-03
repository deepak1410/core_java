package com.dpk.multithreading.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapManager {
    private static ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
           concurrentMap.put("P", 20);
           concurrentMap.put("B", 10);
           concurrentMap.put("S", 12);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            concurrentMap.put("D", 15);
            concurrentMap.put("M", 25);
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(concurrentMap.get("P"));
            System.out.println(concurrentMap.get("B"));
            System.out.println(concurrentMap.get("S"));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(concurrentMap.get("D"));
            System.out.println(concurrentMap.get("M"));
        });

        t1.start();
        t2.start();

    }
}
