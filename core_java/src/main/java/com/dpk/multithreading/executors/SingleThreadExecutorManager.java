package com.dpk.multithreading.executors;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorManager {

    public static void main(String[] args) {
        ExecutorService executors = Executors.newSingleThreadExecutor();

        for(int i=0; i<5; i++) {
            executors.execute(new Task("Task " + i));
        }

        executors.shutdown();

    }
}
