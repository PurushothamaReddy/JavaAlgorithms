package com.passion.coding.array;

import java.util.HashMap;

public class PairSumToNumber {
    public static void main(String[] args) {
        int arr[] = {-40, -5, 1, 3, 6, 7, 8, 20};
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
