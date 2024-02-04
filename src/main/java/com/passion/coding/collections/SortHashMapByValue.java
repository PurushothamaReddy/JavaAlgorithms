package com.passion.coding.collections;

import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapByValue {

	public static void main(String[] args) {
		Map<String, Integer> scores = new HashMap<>();

		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);

		System.out.println(scores);

//		scores = sortByValue(scores);
//
//		System.out.println(scores);
		System.out.println(" -------------------");
		scores = sortByValueP(scores);

		System.out.println(scores);

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> scores) {
		Map<String, Integer> sortedByValue = new LinkedHashMap<>();

		// get the entry set
		Set<Entry<String, Integer>> entrySet = scores.entrySet();
		System.out.println(entrySet);

		// create a list since the set is unordered
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
		System.out.println(entryList);

		// sort the list by value
		entryList.sort((x, y) -> x.getValue().compareTo(y.getValue()));
		System.out.println(entryList);

		// populate the new hash map
		for (Entry<String, Integer> e : entryList)
			sortedByValue.put(e.getKey(), e.getValue());

		return sortedByValue;
	}

	private static Map<String,Integer> sortByValueP(Map<String, Integer> scores)  {
		Map<String, Integer> sortByValue = new LinkedHashMap<>();

		List<Entry<String,Integer>> entryList = new ArrayList<>(scores.entrySet());
		Collections.sort(entryList,(e1, e2)-> e1.getValue().compareTo(e2.getValue()));
	//	sortByValue =entryList.stream().collect(Collectors.toMap(e-> e.getKey(),e->e.getValue()));
		for (Entry<String, Integer> e : entryList) {
			sortByValue.put(e.getKey(), e.getValue());
		}
		return sortByValue;
	}
}