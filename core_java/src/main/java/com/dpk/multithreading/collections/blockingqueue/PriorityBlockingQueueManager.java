package com.dpk.multithreading.collections.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class PriorityProducer implements Runnable {
    private BlockingQueue<String> queue;

    public PriorityProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.add("Adam");
        queue.add("William");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        queue.add("John");
        queue.add("Anna");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.add("David");
    }

}

class PriorityConsumer implements Runnable {
    private BlockingQueue<String> queue;

    public PriorityConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!queue.isEmpty()) {
            String item = queue.poll();
            System.out.println(item); // The output will be printed in sorted order
        }
    }
}


public class PriorityBlockingQueueManager {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        Thread producerThread = new Thread(new PriorityProducer(queue));
        Thread consumerThread = new Thread(new PriorityConsumer(queue));

        producerThread.start();
        consumerThread.start();

    }
}
