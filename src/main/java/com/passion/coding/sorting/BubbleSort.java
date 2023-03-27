package com.passion.coding.sorting;

import java.util.Arrays;

public class BubbleSort {

    // swap the adjacent elements in an array if not in order
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("In Sorting:" + Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 5, 1, 4, 7, 6};
        System.out.println("Before sorting:" + Arrays.toString(arr));
        sort(arr);
        System.out.println("After Sorting:" + Arrays.toString(arr));
    }
}
