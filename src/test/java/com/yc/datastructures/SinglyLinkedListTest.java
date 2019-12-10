package com.yc.datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Singly Linked List Tests")
public class SinglyLinkedListTest {

    @Test
    @DisplayName("Test not null")
    public void testListInstantiated() {
        MyList list = new SinglyLinkedList();
        assertNotNull(list);
    }

    @Test
    @DisplayName("Add null to list")
    public void testAddingNull() {
        MyList list = new SinglyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    @DisplayName("Add object to list")
    public void testAddObjectToList() {
        MyList list = new SinglyLinkedList();
        Object element = new Object();
        assertTrue(list.add(element));
    }

    @Test
    @DisplayName("Contains")
    public void testListContainsElement() {
        MyList list = new SinglyLinkedList();
        Object element = new Object();
        assertTrue(list.add(element));
        assertTrue(list.contains(element));
    }
}
