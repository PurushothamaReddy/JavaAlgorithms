package com.passion.coding.string;

import java.util.*;

public class PrintAllAnagramsInSeq {

    private static String printAnagramsInSeq(String[] words) {
        if (words == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String str : words) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortStr, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                entry.getValue().stream().forEach(s -> result.append(s + " "));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "tac", "god", "act" };
        System.out.println(printAnagramsInSeq(words));
    }
}
