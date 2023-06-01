package com.dpk.ds.stack;

public class Stack<T> {
    private T[] stack;
    private int top;
    private int maxSize;

    public Stack(int maxSize) {
        stack = (T[]) new Object[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize -1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void push(T item) {
        if(isFull()) {
            System.out.println("The stack is full");
            return;
        }

        stack[++top] = item;
    }

    public T pop() {
        if(isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }

        return stack[top--];
    }

    public T top() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return stack[top];
    }

    public void display() {
        System.out.println("Displaying stack");
        for (int i=top; i>= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Create a stack");
        Stack stack1 = new Stack(5);

        int item1 = 2, item2 = 4, item3 = 6, item4 = 8, item5 = 10, item6 = 12;

        System.out.println("Add an item : " + item1);
        stack1.push(item1);

        System.out.println("Add an item : " + item2);
        stack1.push(item2);

        System.out.println("Add an item : " + item3);
        stack1.push(item3);

        System.out.println("Add an item : " + item4);
        stack1.push(item4);

        System.out.println("Add an item : " + item5);
        stack1.push(item5);

        System.out.println("Add an item : " + item6);
        stack1.push(item6);

        stack1.display();

        System.out.println("Pop the stack");
        int item = (int)stack1.pop();
        System.out.println("Popped item = " + item);

        System.out.println("Pop the stack");
        item = (int)stack1.pop();
        System.out.println("Popped item = " + item);

        System.out.println("Peek the stack");
        item = (int)stack1.top();
        System.out.println("Peeked item = " + item);

        stack1.display();

        System.out.println("Pop the stack");
        item = (int)stack1.pop();
        System.out.println("Popped item = " + item);

        System.out.println("Pop the stack");
        item = (int)stack1.pop();
        System.out.println("Popped item = " + item);

        System.out.println("Pop the stack");
        item = (int)stack1.pop();
        System.out.println("Popped item = " + item);

        System.out.println("Pop the stack");
        stack1.pop(); // The Stack should be empty here

    }
}
