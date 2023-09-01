package com.passion.coding.stack;

import java.util.Stack;

public class SortStackUsingAnotherStackP {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(200);
        s1.push(150);
        s1.push(100);
        s1.push(300);
        System.out.println("Before Sort:" + s1);
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int x = s1.pop();

            while (!s2.isEmpty() && s2.peek() > x) {
                s1.push(s2.pop());
            }
            s2.add(x);
        }

        System.out.println("After Sorting:" + s2);
    }
}
