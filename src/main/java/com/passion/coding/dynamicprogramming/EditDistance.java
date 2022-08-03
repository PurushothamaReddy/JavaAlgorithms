package com.passion.coding.dynamicprogramming;

import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String s1 = scn.nextLine();
        String s2 = scn.nextLine();

        System.out.println(editDistRecusrsive(s1, s2));
//        Input:   str1 = "sunday", str2 = "saturday"
//        Output:  3
//        Last three and first characters are same.  We basically
//        need to convert "un" to "atur".  This can be done using
//        below three operations.
//                Replace 'n' with 'r', insert t, insert a

    }

    public static int editDistRecusrsive(String s1, String s2) {
        /*
         * basecase : if one String is exhausted, return the remaining
         * length of the other String, as we have to do atleast that
         * many opeartions to make the Strings equal.
         */
        if (s1.length() == 0) {
            return s2.length();
        }

        if (s2.length() == 0) {
            return s1.length();
        }

        /*
         * we are working on the first characters of both
         * strings and recurring for the remaining length
         * of the strings.
         */

        String remaining1 = s1.substring(1);
        String remaining2 = s2.substring(1);
        int recRes = 0;

        if (s1.charAt(0) == s2.charAt(0)) {
            /* if characters match we dont need to do any
             * operations to make them equal, so leave them
             * and recur for the remaining strings
             */
            recRes = editDistRecusrsive(remaining1, remaining1);
        } else {

            /*
             * if the first characters dont match, then we add +1
             * for the operation used in making the first characters
             * of the strings equal, and recur for the remaining Strings
             * and our final answer will be 1 + minimum of the operations
             * taken to convert remaining String! and remaining String2.
             */
            recRes = 1 + Math.min(editDistRecusrsive(remaining1, remaining2),
                    Math.min(editDistRecusrsive(remaining1, s2),
                            editDistRecusrsive(s1, remaining2)));

        }

        return recRes;
    }
}