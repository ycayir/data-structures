package com.yc.datastructures;

import java.util.EmptyStackException;

public class ArrayStack implements Stack {

    private final static int DEFAULT_SIZE = 5;
    private Object[] items;
    private int top;

    public ArrayStack() {
        this.items = new Object[DEFAULT_SIZE];
        this.top = 0;
    }

    @Override
    public boolean push(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot enter null value");
        }
        if (isFull()) {
            throw new IllegalArgumentException("Stack is already full");
        }

        items[top+1] = o;
        top++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object toBeRemoved = items[top];
        items[top] = null;
        top--;
        return toBeRemoved;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items[top];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return items.length == top+1;
    }

}
