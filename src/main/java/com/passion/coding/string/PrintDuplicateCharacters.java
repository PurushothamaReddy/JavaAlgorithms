package com.passion.coding.string;

public class PrintDuplicateCharacters {
//https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
    private static void printDuplicateCharacters(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        for(char ch : str.toCharArray()){
            if(str.indexOf(ch) != str.lastIndexOf(ch)){
                System.out.println(ch);
            }
        }
    }

    public static void main(String[] args) {
        printDuplicateCharacters("w3schoolssl");
    }
}
