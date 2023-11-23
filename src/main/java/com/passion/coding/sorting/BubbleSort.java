package com.passion.coding.sorting;

import java.util.Arrays;

public class BubbleSort {

    // swap the adjacent elements in an array if not in order

    private static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n -i- 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("In Sorting:" + Arrays.toString(arr));

            }
        }
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                System.out.println("In Sorting:" + Arrays.toString(arr));

            }
        }

    }

    public static void sortP(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length-1; j++) {

                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("In Sorting:" + Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 5, 1, 4, 7, 6};
        System.out.println("Before sorting:" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Sorting:" + Arrays.toString(arr));

    }
}
