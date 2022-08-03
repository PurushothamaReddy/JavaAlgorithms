package com.passion.coding.stack;

//To implement stack feature (LIFO) Insert(push) and delete(pop) from single linked list

public class StackUsingLinkedList {
    Node sp;

    public StackUsingLinkedList() {
        sp = null;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void push(int data) {
        if (sp == null) {
            sp = new Node(data, null);
        } else {
            Node tnew = new Node(data, null);
            tnew.setNext(sp);
            sp = tnew;
        }
    }

    public int pop() {
        if (sp == null) {
            System.out.println("underflow");
            return -1;
        } else {
            int data = sp.data;
            sp = sp.next;
            return data;
        }
    }

    public void display() {
        Node tmp = sp;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int peek() {
        if (sp == null) {
            System.out.println("Underflow");
            return -1;
        }
        return sp.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(100);
        stackUsingLinkedList.push(200);
        stackUsingLinkedList.push(300);
        stackUsingLinkedList.push(400);
        stackUsingLinkedList.display();
        System.out.println("Pop:" + stackUsingLinkedList.pop());
        System.out.println("Peek:" + stackUsingLinkedList.peek());


    }
}
