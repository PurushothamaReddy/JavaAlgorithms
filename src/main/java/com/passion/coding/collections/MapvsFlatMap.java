package com.passion.coding.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        List<String> lengths = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(lengths);
        List<Character> chars = fruits.stream().flatMap(s-> s.chars().mapToObj(a->(char)a)).collect(Collectors.toList());
        System.out.println(chars);

        List<String> strings = Arrays.asList("apple hello", "banana hexv", "cherry flatmap");
        System.out.println(strings.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList()));
        System.out.println(strings.stream().flatMap(s -> Arrays.asList(s.split(" ")).stream()).collect(Collectors.toList()));
        String text ="hello\"hello";


    }
}
