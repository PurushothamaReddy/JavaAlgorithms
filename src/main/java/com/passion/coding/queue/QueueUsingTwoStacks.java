package com.passion.coding.queue;

import java.util.Queue;
import java.util.Stack;
//Implement FIFO
public class QueueUsingTwoStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data){

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
       s1.push(data);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int dequeue(){
        return s1.pop();
    }

    public void display(){
        System.out.println(s1);
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        queueUsingTwoStacks.enqueue(10);
        queueUsingTwoStacks.enqueue(20);
        queueUsingTwoStacks.enqueue(40);
        queueUsingTwoStacks.enqueue(30);
        queueUsingTwoStacks.enqueue(50);
        queueUsingTwoStacks.display();
        queueUsingTwoStacks.dequeue();
        queueUsingTwoStacks.dequeue();
        queueUsingTwoStacks.display();
    }
}
