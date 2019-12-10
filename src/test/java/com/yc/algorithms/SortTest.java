package com.yc.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Sort Algorithm Tests")
public class SortTest {

    @Nested
    public class BubbleSortTests {

        @Test
        @DisplayName("Test with five element array")
        public void testWithFiveElementArray() {
            int[] arr = {15, 6, 2, 12, 4};
            Sort.bubbleSort(arr);
            int[] sorted = {2, 4, 6, 12, 15};
            assertArrayEquals(sorted, arr);
        }

        @Test
        @DisplayName("Test with empty array")
        public void testWithEmptyArray() {
            int[] arr = {};
            Sort.bubbleSort(arr);
            int[] sorted = {};
            assertArrayEquals(sorted, arr);
        }
    }

    @Nested
    public class SelectionSortTests {

        @Test
        @DisplayName("Test with seven element array")
        public void testWithSevenElementArray() {
            int[] arr = {7, 2, 4, 21, 25, 10, 17};
            Sort.selectionSort(arr);
            int[] sorted = {2, 4, 7, 10, 17, 21, 25};
            assertArrayEquals(sorted, arr);
        }
    }
}
