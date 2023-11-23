package com.passion.coding.string;

import java.util.*;
/*https://www.geeksforgeeks.org/removing-string-that-is-an-anagram-of-an-earlier-string/
Given an array arr of strings, the task is to remove the strings that are an anagram of an earlier string, then print the remaining array in sorted order.

        Examples:

        Input: arr[] = { “geeks”, “keegs”, “code”, “doce” }, N = 4
        Output: [“code”, “geeks”]
        Explanation:
        “geeks” and “keegs” are anagrams, so we remove “keegs”.
        Similarly, “code” and “doce” are anagrams, so we remove “doce”.

        Input : arr[] = {“tea”, “ate”, “anagram”, “eat”, “gramaan”}, N = 5
        Output : [“anagram”, “tea”]
        Explanation: “ate” and “eat” are anagram of “tea”.
        “gramaan” is an anagram of “anagram” hence, array becomes [“anagram”, “tea”].
        Removing string that is an anagram of an earlier string*/
public class FunWithAnagrams {
    private static List<String> funWithAnagrams(List<String> list){
        List<String> result = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for(String str: list){
            String word= sort(str);
            if(!set.contains(word)){
                result.add(str);
                set.add(word);
            }
        }
        Collections.sort(result);
        return result;
    }

    private  static String sort(String str){
        char[] ch= str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);

    }

    public static void main(String[] args) {
//        System.out.println(funWithAnagrams(Arrays.asList("geeks", "keegs","code","doce" )));
//        System.out.println(funWithAnagrams(Arrays.asList("code", "doce", "ecod", "framer", "frame")));
        System.out.println(funWithAnagrams(Arrays.asList("code","aaagmnrs","anagrams","doce", "cedo","ana")));

    }
}
