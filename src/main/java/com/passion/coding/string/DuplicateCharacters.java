package com.passion.coding.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String str="Purushothama Reddy";
        System.out.println(str.chars().count()-str.chars().distinct().count());
        // we can also do with str.indexOf(ch) != str.lastIndexOf(ch) then it is dup character

        HashMap<Character,Integer> countMap= new HashMap<>();
        for(int i=0 ; i<str.length();i++) {
            Character ch= str.charAt(i);
            if(countMap.containsKey(ch)) {
            countMap.put(ch,countMap.get(ch)+1);
            } else {
                countMap.put(ch,1);
            }

        }
        for(Map.Entry<Character,Integer> entry: countMap.entrySet()) {
            if(entry.getValue()>1)
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        List<Character> duplicates= countMap.entrySet().stream().filter(e-> e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
        System.out.println(duplicates);
        System.out.println(countMap.entrySet().stream().filter(e-> e.getValue()>1).collect(Collectors.toMap(e->e.getKey(),e->e.getValue())));

        System.out.println(countMap.entrySet().stream().filter(e-> e.getValue()>1).map(e->e.getKey()+"").collect(Collectors.joining()));
        //https://mkyong.com/java8/java-8-filter-a-map-examples/
    }
}
