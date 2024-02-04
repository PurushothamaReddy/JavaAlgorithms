package com.passion.coding.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ElementFrequencyInsortedArray {

    public static void printElementFrequency(int[] arr) {
        int prev = arr[0], curr;
        int freqCount = 0;
        for (int i = 0; i < arr.length; i++) {
            curr = arr[i];
            if (curr != prev) {
                System.out.println("Frequency of " + prev + " is:" + freqCount);
                freqCount = 1;
            } else {
                freqCount++;
            }
            prev = curr;
            if (i == arr.length - 1) {
                System.out.println("Frequency of " + prev + " is:" + freqCount);
            }
        }
    }

    public static void printElementUsingMap(int[] arr) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        System.out.println(map);
    }

    public static void printElementFreqUsingJavaStream(int[] arr) {

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7};
        printElementFrequency(arr);
        System.out.println("========================");
        //approach 2 using Stream API
        printElementFreqUsingJavaStream(arr);
        System.out.println("========================");
        //approach 3 use hashmap
        printElementUsingMap(arr);
    }
}
