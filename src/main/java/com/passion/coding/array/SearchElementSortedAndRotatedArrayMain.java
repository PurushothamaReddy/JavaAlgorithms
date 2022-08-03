package com.passion.coding.array;

public class SearchElementSortedAndRotatedArrayMain {
    //with O(logn) complexity
    public static void main(String[] args) {
        int arr[] = {16, 19, 21, 25, 3, 5, 8, 10};
        System.out.println("Index of element 5 : " + findElementRotatedSortedArray(arr, 0, arr.length - 1, 5));
    }

    public static int findElementRotatedSortedArray(int[] arr, int low, int high, int number) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == number)
                return mid;
            if (arr[mid] < arr[high]) {

                // right sorted
                if (number > arr[mid] && number <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            } else {
                //Left sorted
                if (number >= arr[low] && number < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }


        }

        return -1;
    }
}