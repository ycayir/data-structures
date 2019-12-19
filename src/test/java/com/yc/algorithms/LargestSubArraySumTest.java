package com.yc.algorithms;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Largest Sub Array Sum Test")
public class LargestSubArraySumTest {

    @Test
    @DisplayName("Unoptimized solution for {-2, -3, 4, -1, -2, 1, 5, -3}")
    public void testFindLargestSubArray() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int largestSum = LargestSubArraySum.maxSumContiguousSubArray(arr);

        assertEquals(7, largestSum);
    }

    @Test
    @DisplayName("Optimized solution for {-2, -3, 4, -1, -2, 1, 5, -3}")
    public void testFindLargestSubArrayOptimized() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int largestSum = LargestSubArraySum.maxSumContiguousSubArrayOptimized(arr);

        assertEquals(7, largestSum);
    }

    @Test
    @DisplayName("Maintaining sub array indexes solution for {-2, -3, 4, -1, -2, 1, 5, -3}")
    public void testFindLargestSubArrayMaintainingStartAndEnd() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int largestSum = LargestSubArraySum.maxSumContiguousSubArrayMaintainingSubArrayStartEndIndexes(arr);

        assertEquals(7, largestSum);
    }
}
