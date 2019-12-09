package com.yc.algorithms;

public class Sort {

    /**
     * Swaps the elements with the given indices in an array
     *
     * @param arr Array
     * @param i first index
     * @param j second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
//                System.out.println("i=" + i + ", arr[i]=" + arr[i] + ", j=" + j + ", arr[j]=" + arr[j]);
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            swap(arr, i, indexOfMin);
        }
    }

    public static void insertionSort(int[] arr) {

    }
}
