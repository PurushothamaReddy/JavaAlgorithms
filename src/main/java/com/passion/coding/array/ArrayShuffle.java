package com.passion.coding.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle {
    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(a1));
        Random r = new Random();
        for (int i = 0; i < a1.length; i++) {
            int randomIndex = r.nextInt(a1.length);
            int temp = a1[randomIndex];
            a1[randomIndex] = a1[i];
            a1[i] = temp;
        }
        System.out.println(Arrays.toString(a1));
    }
}
