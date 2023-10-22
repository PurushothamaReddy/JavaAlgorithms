package com.passion.coding.string;

public class RemoveCharactersFromFirstString {

    private static String removeCharsFromFrist(String first, final String second) {
        if (first == null || second == null) {
            return first;
        }

        for (char c : second.toCharArray()) {
            first = first.replaceAll(c + "", "");
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(removeCharsFromFrist("occurrence", "car"));
    }
}
