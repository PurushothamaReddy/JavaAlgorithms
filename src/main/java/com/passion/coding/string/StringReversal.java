package com.passion.coding.string;

public class StringReversal {
    public static void main(String[] args) {
        String s="HelloWorld";
        System.out.println(reverse(s));
        String str1 = "abcdABCDabcdABCD";

        str1 = str1.replace("a", "");

        System.out.println(str1);
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 is:" + (s1 == s2));

    }
    private static String reverse(String str){
        if(str.length() <=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

    public static String reverseWithoutRecursion(String source){
        if(source == null || source.isEmpty()){
            return source;
        }
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }

        return reverse;
    }

    public static boolean isPalindrome(String str)
    {
        return isPalindrome(str,0,str.length()-1);

    }
    public static boolean isPalindrome(String str,int low, int high)
    {  if(high <= low)
        return true;
    else if (str.charAt(low)!= str.charAt(high))
        return false;
    else
        return isPalindrome(str,low+1,high-1);



    }
    /*
     * Java method to check if a number is palindrome or not
     */
    public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            reverse = reverse * 10 + palindrome % 10;
            palindrome = palindrome / 10;
        }

        // if original and the reverse of number is equal means
        // number is palindrome in Java
        if (number == reverse) {
            return true;
        }
        return false;
    }

    public static int sumOfDigits(int number){
        if(number/10 == 0) return number;

        return number%10 + sumOfDigits(number/10);
    }

    public static int sumOfDigitsIterative(int number){
        int result  = 0;
        while(number != 0){
            result = result + number%10;
            number = number/10;
        }

        return result;
    }
}

