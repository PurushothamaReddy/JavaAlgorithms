package com.passion.coding.array;

public class SecondHighestNumberInArray {
    public static void main(String[] args) {
        int arr[] = {16, 19, 25, 3, 5, 8, 10, 21};
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);
        System.out.println(max);
        printMaxAndSecondMax(arr);
    }

    public static void printMaxAndSecondMax(int[] a) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : a) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        System.out.println("Max:" + max);
        System.out.println("Second Max:" + secondMax);
    }

}
