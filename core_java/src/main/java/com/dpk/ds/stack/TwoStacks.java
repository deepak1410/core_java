package com.dpk.ds.stack;

public class TwoStacks<V> {
    private int maxSize;
    private V[] array;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //insert at top of first stack
    public void push1(V value) {

    }

    //insert at top of second stack
    public void push2(V value) {

    }

    //remove and return value from top of first stack
    public V pop1() {
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        return null;
    }
}