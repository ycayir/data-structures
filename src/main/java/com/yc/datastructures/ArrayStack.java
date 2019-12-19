package com.yc.datastructures;

import java.util.EmptyStackException;

public class ArrayStack implements Stack {

    private final static int DEFAULT_SIZE = 5;
    private Object[] items;
    private int top;

    public ArrayStack() {
        this.items = new Object[DEFAULT_SIZE];
        this.top = -1;
    }

    public ArrayStack(int maxSize) {
        this.items = new Object[maxSize];
        this.top = -1;
    }

    @Override
    public boolean push(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot enter null value");
        }
        if (isFull()) {
            return false;
        }

        top++;
        items[top] = o;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object removed = items[top];
        items[top] = null;
        top--;
        return removed;
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
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return items.length - 1 == top;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i=top; i>=0; i--) {
            str += items[i].toString();
            if (i > 0) {
                str += ", ";
            }
        }
        str += "}";

        return str;
    }

}
