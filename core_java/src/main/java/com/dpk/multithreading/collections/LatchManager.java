package com.dpk.multithreading.collections;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class LatchWorker implements Runnable {
    private int id;
    private CountDownLatch latch;
    public LatchWorker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        doWork();
        latch.countDown(); // This is how the value is decremented in the countdown latch
    }

    public void doWork() {
        System.out.println("Thread with ID " + this.id + " starts working");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class LatchManager {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++) {
            service.execute(new LatchWorker(i, latch));
        }

        try {
            latch.await(); // This makes the current thread to wait until the latch has counted down to zero.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All the tasks have been completed");
        service.shutdown();
    }
}
