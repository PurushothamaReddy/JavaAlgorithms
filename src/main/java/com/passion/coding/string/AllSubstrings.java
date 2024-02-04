package com.passion.coding.string;

public class AllSubstrings {
    public static void main(String[] args) {
        String str = "abcd";
        printAllSubstrings(str);
        System.out.println("=======================");
        printSubStringsP(str);
    }

    private static void printAllSubstrings(String str) {
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }


    private static void printSubStringsP(final String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
}
