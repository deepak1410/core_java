package com.dpk.multithreading.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            for(int i=0; i<1000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The size of the list =" + list.size());
    }
}
