package com.passion.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterWords {

    public static String[] filterwords(String[] words, String letters) {

        String[] result = new String[words.length];
        List<String> list = new ArrayList<>();
        char[] chars = letters.toCharArray();
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            boolean filter = true;
            for (int j = 0; j < chars.length; j++) {

                if (words[i].indexOf(chars[j]) != -1) {
                    result[k++] = words[i];
                    filter = false;
                    break;
                }
            }
            if (!filter) {
                System.out.println(words[i]);
            }

        }
//        String[] stringArray = list.toArray(new String[0]);
        return result;
    }

    public static void main(String[] args) {
        String[] result = filterwords(new String[]{"the", "dog", "got", "a", "bone"}, "ae");
        System.out.println(Arrays.toString(result));

    }
}