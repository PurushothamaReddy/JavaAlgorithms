package com.passion.coding.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatedCharacterFinder {

    public static char firstNonRepeatedCharacter(String input) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (char ch : input.toCharArray()) {
            if (charCount.get(ch) == 1) {
                return ch;
            }
        }

        return '\0'; // return null character if all characters are repeated
    }
    public static void main(String[] args) {
        String str = "abcdhjkbc";

        for(char ch: str.toCharArray()){
            if( str.indexOf(ch) == str.lastIndexOf(ch)){
                System.out.println(ch);
                break;
            }
        }
        System.out.println(firstNonRepeatedCharacter(str));
        // approach 2 use linkedhashmap with counts and get the first char with count 1
    }
}
