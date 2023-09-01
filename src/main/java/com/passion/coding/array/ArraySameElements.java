package com.passion.coding.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySameElements {
    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3, 2, 1};
        Integer[] a2 = {1, 2, 3};

        Arrays.sort(a1);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));
        System.out.println(isArraysEqual(a1, a2));

    }


    public static boolean isArraysEqual(final Object[] a1, final Object[] a2) {
        Set<Object> set1 = new HashSet<>(Arrays.asList(a1));
        Set<Object> set2 = new HashSet<>(Arrays.asList(a2));
        if (set1.size() != set2.size()) {
            return false;
        }
        System.out.println(set1);
        System.out.println(set2);
        for (Object o : set1) {
            if (!set2.contains(o)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isArrayEquals(final Object[] a1, final Object[] a2) {
        Set<Object> s1 = new HashSet<>(Arrays.asList(a1));
        Set<Object> s2 = new HashSet<>(Arrays.asList(a2));

        if (s1.size() != s2.size()) {
            return false;
        }
        for (Object o : s1) {
            if (!s2.contains(o)) {
                return false;
            }
        }
        return true;
    }
}
