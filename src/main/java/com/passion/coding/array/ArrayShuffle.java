package com.passion.coding.array;

import com.fasterxml.jackson.databind.util.Converter;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle {
    public void fun1() {
        int num=1;
//        Converter<Integer,String> converter = (from)-> String.valueOf(from+num);
        num=3;
    }
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
