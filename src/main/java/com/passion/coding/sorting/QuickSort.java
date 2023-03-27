package com.passion.coding.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println(" Pi " + arr[pi]);
            System.out.println("In Sorting:" + Arrays.toString(arr));
            sort(arr, low, pi);
            sort(arr, pi + 1, high);
        }
    }

    //https://www.youtube.com/watch?v=7h1s2SojIRw
    // take first element as pivot
    // if i<pivot increment i
    //if j>pivot decrement j
    // else swap
    // at the end where j>i swap pivot with j
    //repeat these steps for left sub array and right sub array
    public static int partition(int[] arr, int low, int high) {
        int i = low, j = high;
        int pi = arr[low];
        while (i < j) {
            while (arr[i] <= pi) {
                i++;
            }
            while (arr[j] > pi) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        int[] arr1 = {8, 9, 5, 1, 4, 7, 6};
//        https://www.youtube.com/watch?v=7h1s2SojIRw
        System.out.println("Before sorting:" + Arrays.toString(arr));
        sortP(arr, 0, arr.length - 1);
//        System.out.println("After part:" + partition(arr, 0, arr.length - 1));
        System.out.println("After Sorting:" + Arrays.toString(arr));
    }

    public static  void sortP(int[] arr,int low,int high) {
        if(low < high) {
            int pivot = partitionP(arr,low,high);
            System.out.println(" Pi " + arr[pivot]);
            System.out.println("In Sorting:" + Arrays.toString(arr));
            sortP(arr,low,pivot);
            sortP(arr,pivot+1,high);
        }
    }

    public static int partitionP(int[] arr, int low, int high){
        int i=low,j=high;
        int pivot=arr[low];
        while (i<j) {
            while (arr[i]<=pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<j){
                int temp= arr[i];
                arr[i]= arr[j];
                arr[j] =temp;
            }
        }
        int temp= arr[low];
        arr[low]= arr[j];
        arr[j]= temp;
        return j;
    }
}
