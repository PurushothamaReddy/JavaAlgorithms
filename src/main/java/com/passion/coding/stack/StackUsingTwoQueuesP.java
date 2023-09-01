package com.passion.coding.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueuesP {

    private Queue<Integer> q1 = new LinkedList<>();

    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int n) {
        q2.add(n);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp= q1;
        q1=q2;
        q2=temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return q1.poll();
    }

    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return q1.peek();
    }
}
