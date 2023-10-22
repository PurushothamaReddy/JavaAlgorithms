package com.passion.coding.string;

import java.util.Arrays;

public class RemoveDuplicateInString {
    //https://www.geeksforgeeks.org/java-program-to-remove-duplicates-from-a-given-string/
    private static String removeDupliactesFromGivenString(final String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int index = 0;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int j = 0;
            for (; j < i; j++) {
                if (ch[i] == ch[j]) {
                    break;
                }
            }
            if (i == j) {
                ch[index++] = ch[i];
            }
        }

        return String.valueOf(Arrays.copyOf(ch, index));
    }

    private static String removeDupliactesFromGivenStringWithSorting(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        StringBuilder result = new StringBuilder();
        result.append(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] != ch[i - 1]) {
                result.append(ch[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(removeDupliactesFromGivenString(s));
        System.out.println(removeDupliactesFromGivenStringWithSorting(s));

    }
}
