package com.passion.coding.string;

public class MakingAnagram {

    private static int minNumberOfDeletesToMakeAnagram(String s1, String s2) {
        int counter = 0;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    counter++;
                    // Mark characters as used by replacing them with spaces
//                    s1 = s1.substring(0, i) + ' ' + s1.substring(i + 1);
//                    s2 = s2.substring(0, j) + ' ' + s2.substring(j + 1);
                    break;
                }
            }
        }

//        System.out.println(counter);
        return (s1.length() - counter) + (s2.length() - counter);
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfDeletesToMakeAnagram("rate", "tars"));
        System.out.println(minNumberOfDeletesToMakeAnagram("cde", "abc"));
        System.out.println(minNumberOfDeletesToMakeAnagram("abc", "amnop"));
    }
}
