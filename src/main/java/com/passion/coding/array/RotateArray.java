package com.passion.coding.array;

import java.util.Arrays;

public class RotateArray {

    private static int[] rotateArrayByKTimes(int[] arr, int k) {
        int n = arr.length;
        System.out.println(Arrays.toString(arr));

        int[] result = new int[arr.length];
        int j = 0;
        for (int i = n - 1; i > k; i--) {
            result[j++] = arr[i];
        }
        for (int i = 0; i <= k; i++) {
            result[j++] = arr[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    private static int[] rotateArrayByKTimesSol2(int[] arr, int k) {
        int n = arr.length;
        System.out.println(Arrays.toString(arr));

        int[] result = new int[arr.length];

        for (int i = 0; i < k; i++) {
             int temp =arr[n-1];
            for (int j = n-1; j > 0; j--) {
                arr[j] = arr[j-1];
            }
          arr[0]=temp;
        }
        System.out.println(Arrays.toString(arr));
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrayByKTimesSol2(arr, k);
    }
}
