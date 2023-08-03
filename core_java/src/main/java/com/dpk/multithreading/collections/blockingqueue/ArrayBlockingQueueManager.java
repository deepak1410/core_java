package com.dpk.multithreading.collections.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerWorker implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public ProducerWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                blockingQueue.put(counter);
                System.out.println("Putting item into the queue " + counter);
                counter++;
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class ConsumerWorker implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public ConsumerWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Taking item from the queue " + blockingQueue.take());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ArrayBlockingQueueManager {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread producerThread = new Thread(new ProducerWorker(queue));
        Thread consumerThread = new Thread(new ConsumerWorker(queue));

        producerThread.start();
        consumerThread.start();
    }

}
