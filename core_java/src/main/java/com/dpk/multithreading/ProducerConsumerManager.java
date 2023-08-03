package com.dpk.multithreading;

import java.util.ArrayList;
import java.util.List;

class ProducerConsumer {
    private List<Integer> list = new ArrayList<>();
    private Object lock = new Object();

    private int LOWER_LIMIT = 0;
    private int UPPER_LIMIT = 5;
    private int value = 0;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Produces data...");

            while (true){
                if(list.size() == UPPER_LIMIT) {
                    value = 0;
                    System.out.println("Waiting for items to remove");
                    lock.wait();
                } else {
                    list.add(value);
                    System.out.println("Produces " + value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (lock) {
            System.out.println("Consume data");
            while (true) {
                if(list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for items to add");
                    lock.wait();
                } else {
                    System.out.println("Consumes " + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}


public class ProducerConsumerManager {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
