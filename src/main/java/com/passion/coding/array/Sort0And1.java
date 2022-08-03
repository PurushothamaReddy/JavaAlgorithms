package com.passion.coding.array;

import java.util.Arrays;

public class Sort0And1 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 0, 0, 0, 0};
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            if (arr[low] == 0) {
                low++;
            } else if (arr[high] == 1) {
                high--;
            } else {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

}
