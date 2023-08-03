package com.dpk.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockWorker {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer called");
        condition.await(); // Similar to wait()
        System.out.println("Producer again");
        lock.unlock();
    }
    public static void consumer() throws InterruptedException {
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer called");
        Thread.sleep(3000);
        condition.signal(); // Similar to notify()
        lock.unlock();
    }
}

public class ProducerConsumerReentrantManager {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                ReentrantLockWorker.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                ReentrantLockWorker.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
