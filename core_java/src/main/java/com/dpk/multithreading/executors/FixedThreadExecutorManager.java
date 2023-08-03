package com.dpk.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadExecutorManager {

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(5);
        for(int i=0; i<20; i++) {
            executors.execute(new Task("Task " + i));
        }

        // Prevent the executor to execute any further tasks
        executors.shutdown();

        try {
            // Awaits for time before terminating the currently executing tasks
            if(!executors.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
               executors.shutdownNow(); // This will terminate immediately, comment this out if immediate termination is not required
            }
        } catch (InterruptedException e) {
            executors.shutdownNow();
        }
    }
}
