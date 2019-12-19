package com.yc.datastructures;

public interface Stack {

    /**
     * Pushes the given item to the top of this Stack
     *
     * @param   o the item to be push onto this stack
     * @return  <code>true</code> if adding item is successful
     */
    boolean push(Object o);

    /**
     * Removes the item from the top of this stack
     *
     * @return  The object at the top of this stack
     */
    Object pop();

    /**
     * Returns the item at the top of the stack
     *
     * @return  The object at the top of this stack
     */
    Object peek();

    /**
     * Tests if this stack is empty
     *
     * @return  <code>true</code> if and only if this stack has no items
     */
    boolean isEmpty();

    /**
     * Tests if this stack is full
     *
     * @return <code>true</code> if and only if this stack is full
     */
    boolean isFull();
}
