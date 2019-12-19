package com.yc.datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Array Stack Tester")
public class ArrayStackTest {

    @Test
    public void testStackInitialization() {
        ArrayStack stack = new ArrayStack();

        assertNotNull(stack);
    }

    @Test
    public void testAdd() {
        ArrayStack stack = new ArrayStack();
        Object item = new Object();

        assertTrue(stack.push(item));
        assertNotNull(stack);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        ArrayStack stack = new ArrayStack();
        Object item = new Object();
        stack.push(item);

        assertNotNull(stack);
        assertEquals(item, stack.peek());
    }

    @Test
    public void testPop() {
        ArrayStack stack = new ArrayStack();
        Object item = new Object();
        stack.push(item);

        assertNotNull(stack);
        assertEquals(item, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
