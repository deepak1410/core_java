package com.dpk.multithreading.executors;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String id;

    public Task(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running task id= " + id + ", thread id=" + Thread.currentThread().getName());
        long duration = (long)(Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
