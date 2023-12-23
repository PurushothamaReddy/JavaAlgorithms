package com.passion.coding.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicOfStrings {

//https://javatpoint.com/isomorphic-string-in-java#:~:text=The%20string%20is%20called%20isomorphic,letter%20may%20map%20to%20itself.
    private static boolean checkIsomorphic(String str1, String str2) {
        // Case 1: when both of the strings have different lengths
        if (str1.length() != str2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
//        one to one mapping of chars
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (map.containsKey(ch1)) {

                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (map.containsValue(ch1)) {
                    return false;
                }
                map.put(ch1, ch2);
            }
        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println(checkIsomorphic("KITE", "ZXBN"));
        System.out.println(checkIsomorphic("foo", "bar"));
    }
}
