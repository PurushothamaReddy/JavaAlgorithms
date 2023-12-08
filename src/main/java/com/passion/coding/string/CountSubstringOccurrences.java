package com.passion.coding.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {

    private static int countSubstringOccurrences(String str, String subStr) {

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        return count;

    }

    public static void main(String[] args) {
        String inputString = "Java is a widely used programming language. Java is versatile and has a large community.";

        String substring = "Java";
        System.out.println(countSubstringOccurrences(inputString,substring));
       //Approach2:
        Pattern p = Pattern.compile(substring);
        Matcher m = p.matcher(inputString);
        int count = 0;
        while (m.find()){
            count +=1;
        }
        System.out.println(count);
    }
}
