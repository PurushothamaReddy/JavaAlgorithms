package com.passion.coding.sorting;

import java.util.Arrays;

public class InsertionSort {

    // take the portion of the array in reverse order swap the adjacent elements in an array if not in order
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }
            System.out.println("In Sorting:" + Arrays.toString(arr));
        }

    }

//https://www.softwaretestinghelp.com/insertion-sort-in-java/
    //take the portion of the array and sort
    public static void sortP(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <  arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            System.out.println("In Sorting:" + Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 5, 1, 4, 7, 6};
        System.out.println("Before sorting:" + Arrays.toString(arr));
        sortP(arr);
        System.out.println("After Sorting:" + Arrays.toString(arr));
    }
}
