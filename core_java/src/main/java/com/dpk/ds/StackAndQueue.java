package com.dpk.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {

    public static void getStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(3);

        System.out.println("Popped item = " + stack.pop());
        System.out.println("Popped item = " + stack.pop());
        System.out.println("top = " + stack.peek());

    }

    public static void getQueue() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(5);
        queue.add(8);
        queue.add(9);
        queue.add(4);

        System.out.println("Polled item = "  + queue.poll());
        System.out.println("Polled item = "  + queue.poll());
        System.out.println("Polled item = "  + queue.poll());
        System.out.println("Peaked item from queue = " + queue.peek());

    }

    public static void main(String[] args) {
        getStack();
        getQueue();
    }
}
