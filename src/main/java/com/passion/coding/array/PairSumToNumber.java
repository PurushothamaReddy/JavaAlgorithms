package com.passion.coding.array;

import java.util.HashMap;

public class PairSumToNumber {

    static void printPairs(int arr[], int n, int sum) {
        // int count = 0;
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        // Consider all possible pairs
        // and check their sums
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
//                    System.out.println("(" + arr[i] + ", "
//                            + arr[j] + ")");
                    //https://stackoverflow.com/questions/56437173/find-non-repetitive-pairs-in-an-array-that-add-up-to-a-given-sum
                    if ((!resultMap.containsKey(arr[j]) && !resultMap.containsValue(arr[i])))
                        resultMap.put(arr[i], arr[j]);
                }
            }
        }

        System.out.println(resultMap);
    }

    public static void main(String[] args) {
        int arr[] = {-40, -5, 1, 3, 6, 7, 8, 20, 8, 7};
        printPairs(arr, arr.length, 15);
        System.out.println("===============================");
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        int num = 15;
        for (int a : arr) {
            if (map.containsValue(a)) {
//                System.out.println(num - a + " " + a);
                resultMap.put(a, num - a);
            } else {
                map.put(a, num - a);
            }
        }
        System.out.println(resultMap);
    }
}
