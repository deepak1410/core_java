package com.dpk.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorManager  {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Updating and downloading stock market data from web"));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long initialDelay = 1L;
        long period = 2L;
        executor.scheduleAtFixedRate(thread, initialDelay, period, TimeUnit.SECONDS);
    }
}
