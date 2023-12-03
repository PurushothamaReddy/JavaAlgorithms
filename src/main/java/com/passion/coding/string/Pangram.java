package com.passion.coding.string;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

    private static boolean isPangram(String str) {
        boolean isPenGram = true;
        str = str.toLowerCase();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!str.contains(ch + "")) {
                isPenGram = false;
                break;
            }
        }

        return isPenGram;

    }

    public static void main(String[] args) {
        String str = "Abcdefghijklmnopqrstuvwxyz12";
//        System.out.println(isPangram(str));
//       str= str.toLowerCase();
        if (str.length() < 26) {
            System.out.println("not pangram");
            return;
        }

        Set<Character> set = new HashSet<>();

        for(char c : str.toCharArray()) {
            if(Character.isLetter(c) && (!Character.isWhitespace(c))) {
                set.add(c);
            }
        }

        System.out.println(set.size() == 26 ? "pangram" : "not pangram");

    }
}
