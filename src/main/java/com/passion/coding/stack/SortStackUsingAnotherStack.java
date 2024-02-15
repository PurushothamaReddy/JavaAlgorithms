package com.passion.coding.stack;

import java.util.Stack;

public class SortStackUsingAnotherStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(4);
        s1.push(3);
        s1.push(5);
        System.out.println("Before Sorting:" + s1);
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int x = s1.pop();
            //make s2 is sorted from beginning if s2 peek value is greater than x
            while (!s2.isEmpty() && s2.peek() > x) {
                s1.push(s2.pop());
            }
            s2.push(x);
        }
        System.out.println("After Sorting:" + s2);
    }


    private static void sortUsingAnotherStack(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<>();

        while (!s1.isEmpty()) {
            int x= s1.pop();
            while (!s2.isEmpty() && s2.peek()>x){
                s1.push(s2.pop());
            }
            s2.push(x);
        }
        System.out.println(s2);
    }
}
