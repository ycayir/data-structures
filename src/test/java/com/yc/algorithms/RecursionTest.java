package com.yc.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Recursion Algorithm Tests")
public class RecursionTest {

    @Test
    @DisplayName("Remove vowels from 'recurse'")
    public void testRemoveVowels() {
        String removed = Recursion.removeVowels("recurse");
        assertEquals("rcrs", removed);
    }

    @Test
    @DisplayName("Remove vowels from 'galatasaray'")
    public void testRemoveVowels2() {
        String removed = Recursion.removeVowels("galatasaray");
        assertEquals("gltsry", removed);
    }

    @Test
    @DisplayName("Remove capital vowels")
    public void testRemoveVowels3() {
        String removed = Recursion.removeVowels("AOUEI");
        assertEquals("", removed);
    }
}
