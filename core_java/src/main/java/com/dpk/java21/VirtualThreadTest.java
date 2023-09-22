package com.dpk.java21;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadTest {

    public Runnable incrementAndGetThread(AtomicInteger atomicInteger) {
        return  () -> {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (Exception ex) {
                System.out.println(ex);
            }

            System.out.println("Work completed - " + atomicInteger.incrementAndGet());
        };
    }

    public void callUsingPlatformThreads() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Instant start = Instant.now();

        try (var executor = Executors.newFixedThreadPool(1000)) {
            for(int i=0; i< 10_000; i++) {
                executor.submit(incrementAndGetThread(atomicInteger));
            }
        }

        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println("Total elapsed time in milli = " + elapsedTime);
    }

    public void callUsingVirtualThreads() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Instant start = Instant.now();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i=0; i < 10_000; i++) {
                executor.submit(incrementAndGetThread(atomicInteger));
            }
        }

        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println("Total elapsed time in millis =" + elapsedTime);
    }

    public static void main(String[] args) {
        VirtualThreadTest vtt = new VirtualThreadTest();

        // Find elapsed time in millis
         vtt.callUsingPlatformThreads(); // 100,261 ms on 100 threads, 10,151 ms on 1k threads, OOM on 10k threads

        // Find elapsed time in millis
        //vtt.callUsingVirtualThreads(); // 1379 milliseconds
    }
}
