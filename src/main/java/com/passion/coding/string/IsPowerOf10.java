package com.passion.coding.string;

public class IsPowerOf10 {

   private static boolean isPowerOf10(long number) {
        while (number % 10 == 0 && number != 0) {
            number = number / 10;
        }
        return Math.abs(number) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf10(1001));
    }

}
