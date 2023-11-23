package com.passion.coding.array;

import java.util.Arrays;

public class EquilibriumIndexOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        System.out.println(equalibriumIndex(arr));
    }

    private static int equalibriumIndex(int[] arr) {
        long sum = 0, left_sum = 0;

        for (int a : arr) {
            sum += a;
        }
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (sum == left_sum) {
                System.out.println("Index equilibrium:" + i);
                return i;
            }
            left_sum += arr[i];
        }
        return -1;
    }

    private static int equilibrium(int arr[], int n)
    {
        int i, j;
        int leftsum, rightsum;

    /* Check for indexes one by one until
    an equilibrium index is found */
        for (i = 0; i < n; ++i) {

            /* get left sum */
            leftsum = 0;
            for (j = 0; j < i; j++)
                leftsum += arr[j];

            /* get right sum */
            rightsum = 0;
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];

        /* if leftsum and rightsum
        are same, then we are done */
            if (leftsum == rightsum)
                return i;
        }

    /* return -1 if no equilibrium
    index is found */
        return -1;
    }
}
