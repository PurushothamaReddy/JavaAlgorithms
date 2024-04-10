package com.passion.coding.string;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    private static void removeDuplicateCharOfString(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        final StringBuilder result = new StringBuilder();
        set.stream().forEach(s -> result.append(s));
        System.out.println(result.toString());

    }

    private static void printDuplicateCharOfString(String str) {
        List<Character> characterList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            characterList.add(ch);
        }
        Map<Character, Long> map = characterList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println(e.getKey() + " "));
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        removeDuplicateCharOfString(str);
        printDuplicateCharOfString(str);
    }
}
