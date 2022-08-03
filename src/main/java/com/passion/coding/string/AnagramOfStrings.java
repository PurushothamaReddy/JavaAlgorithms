package com.passion.coding.string;

import java.util.Arrays;

public class AnagramOfStrings {
    // Same characters in different order
    public static void main(String[] args) {
        String str1 = "angel";
        String str2 = "angle";
        System.out.println("Is Anagram : " + isAnagramUsingArraysSort(str1, str2));
        System.out.println();
        String str3 = "IndiaVsEngland";
        String str4 = "EnglandIndiaVs";
        System.out.println("Rotation : " + checkRotation(str3, str4));
        System.out.println(10/0);

    }

    /** * This method check is given strings are rotation of each other * @param original * @param rotation * @return true or false */
    public static boolean checkRotation(String original, String rotation) {
        if (original.length() != rotation.length()) { return false; }
        String concatenated = original + original;
        if (concatenated.indexOf(rotation) != -1)
        {
            return true;
        }
        return false;
    }

    private static boolean isAnagramUsingArraysSort(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        // remove all whitespaces and convert strings to lowercase
        str1  = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
//        String strf1= new String(ch1);
//        String strf2= new String(ch2);
//        strf1.equalsIgnoreCase(strf2);
        //convert this to string using String.valaue
        return Arrays.equals(ch1, ch2);
    }

}
