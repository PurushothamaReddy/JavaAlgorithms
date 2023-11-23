package com.passion.coding.string;

public class ReverseWords {

    static  String str;
    public void ReverseWords(){
    System.out.println("In Constructor");
    str= "Hello World";
    }
    private static String reverseWords(String str) {

        if( str == null || str.isEmpty()){
            return str;
        }
       StringBuilder sb = new StringBuilder();

        String[] strArr= str.split(" ");
        for(int i= strArr.length-1;i>=0;i--) {

            sb.append(strArr[i]+" ");
        }
        return sb.toString().substring(0,str.length());
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("alpha bravo charlie delta"));

        ReverseWords rv = new ReverseWords();
        System.out.println(str);
        try{
            badMethod();
            System.out.println("A");
        } catch (Exception e){
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public static void badMethod(){

    }
}
