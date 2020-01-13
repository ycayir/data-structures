package com.yc.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringReverserTest {

    @Test
    @DisplayName("Reverse \"hello\"")
    public void reverseString1() {
        assertEquals("olleh", StringReverser.reverseWithStack("hello"));
    }

    @Test
    @DisplayName("Reverse empty string")
    public void reverseEmptyString() {
        assertEquals("", StringReverser.reverseWithStack(""));
    }

    @Test
    @DisplayName("Reverse null")
    public void reverseNullString() {
        Exception thrown = assertThrows(IllegalArgumentException.class,
                () -> StringReverser.reverseWithStack(null));
    }
}
