package com.passion.coding.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElementsOfList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();
        System.out.println("Duplicate elements");
        list.stream().filter(n-> !set.add(n)).forEach(System.out::println);
        System.out.println("Duplicate elements using complete stream");
        list.stream().filter(x-> Collections.frequency(list,x)>1).forEach(System.out::println);
        System.out.println("Unique elements");
        list.stream().distinct().forEach(System.out::println);

        System.out.println("Sort elements");
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println("Sort elements in Descending");
        System.out.println(list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
        int[] nums={10,15,8,49,25,98,98,32,15};
        Arrays.stream(nums).boxed().collect(Collectors.toList());
        Arrays.asList(nums);
        System.out.println("count each element/word from the String ArrayList in Java8");
        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println("find only duplicate elements with its count from the String ArrayList in Java8");
        System.out.println(list.stream().filter(x-> Collections.frequency(list,x)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        System.out.println(1.0 / 0.0);


        Map<String,String> map = new HashMap<String,String>();
        map.put("Effective Java", "Kathy Sierra");
        map.put("Spring in Action", "Craig Walls");
        map.put("Hibernate in Action", "Gavin King");
        map.put("Pro Angular", "Freeman");
        map.put("Pro Spring Boot", "Felipe Gutierrez");
        System.out.println(map);
        System.out.println("==============");
//Only modify if key already exists in the map
        map.computeIfPresent("Effective Java",(key,value)->"Effective Java 8");

        //Only modify if key doesn't exist in the map
        map.computeIfAbsent("Core Java", (value) -> value+" Kathy Sierra");
        map.putIfAbsent("Core Java 21", " Kathy Sierra");

//        System.out.println(map);
        map.entrySet().stream().forEach(System.out::println);
        System.out.println("==============");
        map.entrySet().iterator()
                .forEachRemaining(System.out::println);
    }
}
