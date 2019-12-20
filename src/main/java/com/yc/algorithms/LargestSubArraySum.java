package com.yc.algorithms;

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers
 * which has the largest sum.
 *
 * For example:
 *      int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3}
 *
 *      4 + (-1) + (-2) + 1 + 5 = 7
 *      Maximum contiguous array sum is 7.
 */
public class LargestSubArraySum {

    /**
     * This is Jay Kadane's algorithm
     * @param   arr Given array
     * @return  The sum of the maximum sub array
     */
    public static int maxSumContiguousSubArray(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int temp_sum = 0;

        for (int i=0; i<arr.length; i++) {
            temp_sum = temp_sum + arr[i];
            if (max_so_far < temp_sum) {
                max_so_far = temp_sum;
            }
            if (temp_sum < 0) {
                temp_sum = 0;
            }
        }

        return max_so_far;
    }

    /**
     * This is Jay Kadane's algorithm using <code>Math</code> library
     * @param   arr Given array
     * @return  The sum of the maximum sub array
     */
    public static int maxSumContiguousSubArrayOptimized(int[] arr) {
        int max_so_far = arr[0];
        int temp_sum = arr[0];

        for (int i=1; i<arr.length; i++) {
            temp_sum = Math.max(arr[i], temp_sum + arr[i]);
            max_so_far = Math.max(max_so_far, temp_sum);
        }

        return max_so_far;
    }

    public static int maxSumContiguousSubArrayMaintainingSubArrayStartEndIndexes(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0, end = 0, s = 0;

        for (int i=0; i<arr.length; i++) {
            max_ending_here += arr[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }

        System.out.println("Max contiguous sum is " + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);

        return max_so_far;
    }
}
