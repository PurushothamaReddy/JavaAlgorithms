package com.passion.coding.stack;

public class StackUsingArray {

    int stop;
    int arr[];

    public StackUsingArray(int size) {
        this.stop = -1;
        arr = new int[size];
    }

    public void push(int value) {

        if (stop > arr.length) {
            System.out.println("Stack Overflow");
            return;
        } else {
            arr[++stop] = value;
        }
    }

    public int pop() {
        if (stop == -1) {
            System.out.println("Stack Under flow");
            return -1;
        } else {
            return arr[stop--];
        }
    }

    public int peek() {
        if (stop == -1) {
            System.out.println("Stack Under flow");
            return -1;
        } else {
            return arr[stop];
        }
    }

    public void display() {
        for (int i = stop; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArray sa = new StackUsingArray(5);
        sa.push(10);
        sa.push(20);
        sa.push(30);
        sa.push(40);
        sa.display();
        System.out.println(sa.pop());
        System.out.println(sa.peek());

    }

}
