package com.dpk.ds.queue;

public class Queue<T> {
    private T[] queue;
    private int maxSize;
    private int currentSize;
    private int front;
    private int back;

    public Queue (int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        back = -1;
        currentSize = 0;
        queue = (T[]) new Object[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public T peek() {
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        return queue[front];
    }

    public void enqueue(T item) {
        if(isFull()) {
            System.out.println("Item can not be added as the queue is full");
            return;
        }
        back = (back +1) % maxSize;
        queue[back] = item;
        currentSize++;
    }

    public T dequeue() {
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        T item = queue[front];
        front = (front +1) % maxSize;
        currentSize--;
        return item;
    }

    public void display() {
        System.out.println("Displaying the queue");
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }

        for(int i=front; i<= back; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        int maxSize = 5;
        System.out.println("Create a queue with maxSize =" + maxSize);
        Queue queue1 = new Queue(maxSize);

        for(int i=1; i<= maxSize +1; i++) {
            int item = i*2;
            System.out.println("Add item to the queue: " + item);
            queue1.enqueue(item);
        }


        queue1.display();
        int removeItems = 2;
        System.out.println("Remove " + removeItems + " items from the queue");
        for(int i=0; i< removeItems; i++) {
            queue1.dequeue();
        }

        queue1.display();

        removeItems = 4;
        System.out.println("Remove " + removeItems + " items from the queue");
        for(int i=0; i< removeItems; i++) {
            queue1.dequeue();
        }

        queue1.display();
    }

}
