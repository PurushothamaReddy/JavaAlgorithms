package com.passion.coding.previous;

public class CharClassification {

    public static String check(char ch)
    {

        if (ch >= 'A' && ch <= 'Z')
            return "upper";
        else if (ch >= 'a' && ch <= 'z')
           return "lower";
        else if (ch >= '0' && ch <= '9')
            return "digit";
        else
            return "others";
    }
    public static void main(String[] args) {
        System.out.println(check('9'));
    }
}
