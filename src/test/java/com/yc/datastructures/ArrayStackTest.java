package com.yc.datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Array Stack Tester")
public class ArrayStackTest {

    @Test
    @DisplayName("Initialization")
    public void testStackInitialization() {
        ArrayStack stack = new ArrayStack();

        assertNotNull(stack);
    }

    @Test
    @DisplayName("Add single item to one array stack")
    public void testAdd() {
        ArrayStack stack = new ArrayStack(1);
        Object item = new Object();

        assertTrue(stack.push(item));
        assertNotNull(stack);
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Adding null value")
    public void testAddNullValue() {
        ArrayStack stack = new ArrayStack(1);

        Exception thrown = assertThrows(IllegalArgumentException.class,
                () -> stack.push(null));
        assertTrue(thrown.getMessage().contains("Cannot enter null value"));
    }

    @Test
    @DisplayName("Adding more than stack size")
    public void testAddMoreThanStackSize() {
        ArrayStack stack = new ArrayStack(1);
        Object item1 = new Object();
        Object item2 = new Object();

        assertTrue(stack.push(item1));
        assertFalse(stack.push(item2));
        assertNotNull(stack);
        assertTrue(stack.isFull());
    }

    @Test
    public void testPeek() {
        ArrayStack stack = new ArrayStack(1);
        Object item = new Object();
        stack.push(item);

        assertNotNull(stack);
        assertEquals(item, stack.peek());
    }

    @Test
    public void testPop() {
        ArrayStack stack = new ArrayStack(1);
        Object item = new Object();
        stack.push(item);

        assertNotNull(stack);
        assertEquals(item, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
