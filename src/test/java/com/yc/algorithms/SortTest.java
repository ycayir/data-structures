package com.yc.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Sort Algorithm Tests")
class SortTest {

    @Nested
    @DisplayName("Bubble Sort Tests")
    class BubbleSortTests {

        @Test
        @DisplayName("Bubble Sort 1")
        void testBubbleSort1() {
            int[] arr = {15, 6, 2, 12, 4};
            Sort.bubbleSort(arr);
            int[] sorted = {2, 4, 6, 12, 15};
            assertArrayEquals(sorted, arr);
        }

        @Test
        @DisplayName("Bubble Sort 2")
        void testBubbleSort2() {
            int[] arr = {};
            Sort.bubbleSort(arr);
            int[] sorted = {};
            assertArrayEquals(sorted, arr);
        }
    }

    @Nested
    @DisplayName("Selection Sort Tests")
    class SelectionSortTests {

        @Test
        @DisplayName("Selection Sort 1")
        void testSelectionSort1() {
            int[] arr = {7, 2, 4, 21, 25, 10, 17};
            Sort.selectionSort(arr);
            int[] sorted = {2, 4, 7, 10, 17, 21, 25};
            assertArrayEquals(sorted, arr);
        }
    }

}
