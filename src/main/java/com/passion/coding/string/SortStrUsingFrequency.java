package com.passion.coding.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortStrUsingFrequency {
    public static void main(String[] args) {
        String str = "Aabb";
        System.out.println(sortUsingFreq(str));
    }

    private static String sortUsingFreq(String str) {
        List<Character> characterList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            characterList.add(ch);
        }
        String result = "";
        Map<Character, Long> map = characterList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<Character, Long>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<Character, Long> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                result += entry.getKey();
            }
        }
        return result;
    }
}
