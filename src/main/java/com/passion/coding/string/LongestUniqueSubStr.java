package com.passion.coding.string;

import java.util.HashMap;

public class LongestUniqueSubStr {

    public static boolean isUniqueCharacter(String str) {
        for(int i=0;i< str.length();i++){
            if(str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public  static String longestUniqueSubStr(String s)
    {

        // Creating a set to store the last positions of occurrence
        HashMap<Character, Integer> seen = new HashMap<>();
        int maximum_length = 0;
        String max="";
        // starting the initial point of window to index 0
        int start = 0;

        for(int end = 0; end < s.length(); end++)
        {
            // Checking if we have already seen the element or not
            if(seen.containsKey(s.charAt(end)))
            {
                // If we have seen the number, move the start pointer
                // to position after the last occurrence
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
                String str=s.substring(start,end+1);
                if(str.length()>max.length()) {
                    max = str;
                }
            }

            // Updating the last seen value of the character
            seen.put(s.charAt(end), end);
//            maximum_length = Math.max(maximum_length, end-start + 1);
        }
        return max;
    }

    public static String maxUniqueCharacterSubStr(String str) {
        int max_len=0;
        String max="";
        for(int i=0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                String sub =str.substring(i,j);
                if(isUniqueCharacter(sub)){
                    if(sub.length() > max_len){
                        max_len =sub.length();
                        max=sub;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueCharacterSubStr("GEEKSFORGEEKS"));
        System.out.println(maxUniqueCharacterSubStr("ABDEFGABEF"));
        System.out.println(longestUniqueSubStr("ABDEFGABEF"));
        System.out.println(longestUniqueSubStr("GEEKSFORGEEKS"));

    }
}
