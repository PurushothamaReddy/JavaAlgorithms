package com.passion.coding.sg;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;


/*
 * Create the Filter and Mapper classes here.
 */

class PrefixPredicate implements Predicate<String>{
    String prefix;
    public PrefixPredicate(String prefix) {
        this.prefix = prefix.trim().toLowerCase();
    }

    @Override
public boolean test(String s) {
        if(s!=null && s.startsWith(prefix)){
        return true;
        }
        return false;
        }
        }

class CharCountFunction implements Function<String,CharactersCount> {
    @Override
    public CharactersCount apply(String s) {
        // else use Hashset and return its size  HashSet<Character>
        return new CharactersCount(s,(int)s.chars().distinct().count());
    }
}
class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;
    
    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }
    
    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );
        PrefixPredicate prefixPredicate = new PrefixPredicate(scanner.nextLine());
        CharCountFunction charCountFunction = new CharCountFunction();
        names.stream()
                .filter(prefixPredicate)
                .map(charCountFunction)
                .forEachOrdered(System.out::println);
    }
}