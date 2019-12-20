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
        int best_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int i=0; i<arr.length; i++) {
            current_sum = current_sum + arr[i];
            if (best_sum < current_sum) {
                best_sum = current_sum;
            }
            if (current_sum < 0) {
                current_sum = 0;
            }
        }

        return best_sum;
    }

    /**
     * This is Jay Kadane's algorithm using <code>Math</code> library
     * This version returns 0 if the input contains no positive elements
     * @param   arr Given array
     * @return  The sum of the maximum sub array
     */
    public static int maxSumContiguousSubArrayOptimized1(int[] arr) {
        int best_sum = 0;
        int current_sum = 0;

        for (int i=1; i<arr.length; i++) {
            current_sum = Math.max(0, current_sum + arr[i]);
            best_sum = Math.max(best_sum, current_sum);
        }

        return best_sum;
    }

    /**
     * This is Jay Kadane's algorithm using <code>Math</code> library
     * @param   arr Given array
     * @return  The sum of the maximum sub array
     */
    public static int maxSumContiguousSubArrayOptimized2(int[] arr) {
        int best_sum = arr[0];
        int current_sum = arr[0];

        for (int i=1; i<arr.length; i++) {
            current_sum = Math.max(arr[i], current_sum + arr[i]);
            best_sum = Math.max(best_sum, current_sum);
        }

        return best_sum;
    }

    /**
     * Not Yet Implemented!
     *
     * <p> See Kadane's second algorithm at
     * <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem"
     * </p>
     *
     * @param arr
     * @return
     */
    public static int maxSumContiguousSubArrayMaintainingSubArrayStartEndIndexes1(int[] arr) {
//        int best_sum = 0;
//        int current_sum = 0;
//        int best_start = 0, best_end = 0, current_start = 0;
//
//        for (int i=0; i<arr.length; i++) {
//            int current_start;
//            int current_end;
//            if (current_sum <= 0) {
//                current_start = curent
//            }
//        }
//
//        System.out.println("Max contiguous sum is " + best_sum);
//        System.out.println("Starting index " + best_start);
//        System.out.println("Ending index " + best_end);
//
//        return best_sum;
        return 0;
    }

    public static int maxSumContiguousSubArrayMaintainingSubArrayStartEndIndexes2(int[] arr) {
        int best_sum = Integer.MIN_VALUE;
        int current_sum = 0;
        int start = 0, end = 0, s = 0;

        for (int i=0; i<arr.length; i++) {
            current_sum += arr[i];

            if (best_sum < current_sum) {
                best_sum = current_sum;
                start = s;
                end = i;
            }

            if (current_sum < 0) {
                current_sum = 0;
                s = i + 1;
            }
        }

        System.out.println("Max contiguous sum is " + best_sum);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);

        return best_sum;
    }
}
