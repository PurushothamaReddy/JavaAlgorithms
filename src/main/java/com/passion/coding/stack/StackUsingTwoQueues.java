package com.passion.coding.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    Queue<Integer> q1= new LinkedList<>();
    Queue<Integer> q2= new LinkedList<>();

    public void push(int data){
        q2.add(data);
        Queue<Integer> temp;
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        temp=q1;
        q1=q2;
        q2=temp;
    }

    public int pop(){
        return q1.poll();
    }

    public void display(){
        System.out.println(q1);
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
        stackUsingTwoQueues.push(100);
        stackUsingTwoQueues.push(200);
        stackUsingTwoQueues.push(300);
        stackUsingTwoQueues.push(400);
        stackUsingTwoQueues.display();
        System.out.println("POP:"+stackUsingTwoQueues.pop());
        stackUsingTwoQueues.display();
    }
}
