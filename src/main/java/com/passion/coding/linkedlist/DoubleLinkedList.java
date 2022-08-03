package com.passion.coding.linkedlist;

public class DoubleLinkedList {
   static Node head;
   static Node tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }


   static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }


    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node tnew = new Node(data);
            tnew.prev = temp;
            temp.next = tnew;
            tail = tnew;
        }
    }

    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void deleteFirst() {
        Node temp = head;
        if (temp.next == null) {
            head = null;
            tail = null;
        } else if (temp != null) {
            temp.next.prev = null;
            head = head.next;
            temp = null;
        }

    }


    public void deleteLast() {
        Node temp = tail;
        if (temp.prev == null) {
            head = null;
            tail = null;
        } else if (temp != null) {
            temp.prev.next = null;
            tail = temp.prev;
            temp.prev = null;
        }

    }

    public int count() {
        Node temp = head;
        int count=0;
        while (temp != null) {
           count++;
            temp = temp.next;
        }
       return count;
    }
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        System.out.println("Display Forward:");
        list.displayForward();
        System.out.println("Display Backward:");
        list.displayBackward();
        list.deleteFirst();
        System.out.println("Display forward after delete first");
        list.displayForward();
        list.deleteLast();
        System.out.println("Display backward after delete last");
        list.displayBackward();


    }
}












