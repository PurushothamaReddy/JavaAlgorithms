package com.passion.coding.string;

public class PermuteString {
    //Function for swapping the characters at position I with character at position j  
    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    public static void main(String[] args) {
        //https://www.javatpoint.com/program-to-find-all-permutations-of-a-string
        String str = "ABC";
        int len = str.length();
        System.out.println("All the permutations of the string are: ");
        generatePermutation(str, 0, len);
        System.out.println("PermP");
        permutation("",str);
        System.out.println("=============***");
        permutationOfStr("",str);
    }

    //Function for generating different permutations of the string  
    public static void generatePermutation(String str, int start, int end) {
        //Prints the permutations  
        if (start == end - 1)
            System.out.println(str);
        else {
            for (int i = start; i < end; i++) {
                //Swapping the string by fixing a character  
                str = swapString(str, start, i);
                //Recursively calling function generatePermutation() for rest of the characters   
                generatePermutation(str, start + 1, end);
//                System.out.println("Beforebacktrack:"+str);
                //Backtracking and swapping the characters again.  
//                str = swapString(str,start,i);
//                System.out.println("Afterbacktrack:"+str);
            }
        }
    }

    public static void permP(String str, int start, int end) {
        if (start == end - 1) {
            System.out.println(str);
        }
        for (int i = start; i < end; i++) {

            str = swapString(str, start, i);
            System.out.println("S:"+str);
            permP(str, start + 1, end);

        }
    }

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i)
                        + word.substring(i + 1, word.length()));
            }
        }

    }


    private static void permutationOfStr(String perm,String word){
        if(word.isEmpty()){
            System.out.println(perm);
        } else {
            for(int i=0;i<word.length();i++) {
                permutationOfStr(perm+word.charAt(i),word.substring(0,i)+word.substring(i+1));
            }
        }
    }

















}