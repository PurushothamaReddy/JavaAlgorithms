package com.passion.coding.array;

import java.util.Arrays;

public class EquilibriumIndexOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        System.out.println(equalibriumIndexP(arr));
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


    private static int equalibriumIndexP(int[] arr) {
        long sum = 0, left_sum = 0;

        sum = Arrays.stream(arr).sum();
        System.out.println(sum);

        for(int i=0;i< arr.length;i++) {

            sum-=arr[i];
            if (sum == left_sum){
                System.out.println("Index equilibrium:" + i);
                return i;
            }
            left_sum +=arr[i];
        }
        return 0;
    }
}
