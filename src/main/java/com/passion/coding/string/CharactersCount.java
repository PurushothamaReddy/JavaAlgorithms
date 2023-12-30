package com.passion.coding.string;

public class CharactersCount {
    public static void main(String[] args) {
        String someString = "JAVA PROGRAMMER";

        for(char c: someString.toCharArray()){
            long count=someString.chars().filter(ch-> ch==c).count();
            System.out.println("Occurances of character: "+c+" count:"+count);
        }
    }
}
