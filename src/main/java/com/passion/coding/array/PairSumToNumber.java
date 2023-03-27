package com.passion.coding.array;

import java.util.HashMap;

public class PairSumToNumber {

    static void printPairs(int arr[], int n, int sum)
    {
        // int count = 0;

        // Consider all possible pairs
        // and check their sums
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (arr[i] + arr[j] == sum)
                    System.out.println("(" + arr[i] + ", "
                            + arr[j] + ")");
    }
    public static void main(String[] args) {
        int arr[] = {-40, -5, 1, 3, 6, 7, 8, 20};
        printPairs(arr, arr.length, 15);
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 15;
        for (int a : arr) {
            if (map.containsValue(a)) {
                System.out.println(num - a + " " + a);
            } else {
                map.put(a, num - a);
            }
        }

    }
}
