package com.passion.coding.stack;

public class StackUsingLinkedListP {

    Node sp;

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void push(int data){
        if(sp== null){
            sp = new Node(data);
        } else{
            Node tnew= new Node(data);
            tnew.next=sp;
            sp=tnew;
        }
    }

    public int pop(){
        if(sp==null){
            System.out.println("Stack underflow");
            return -1;
        }
        int data= sp.data;
        sp=sp.next;
        return data;
    }

    public int peek(){
        if(sp==null){
            System.out.println("Stack underflow");
            return -1;
        }
        return sp.data;
    }

    public void display(){
        Node temp=sp;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
    }
    public static void main(String[] args) {
        StackUsingLinkedListP stackUsingLinkedList = new StackUsingLinkedListP();
        stackUsingLinkedList.push(100);
        stackUsingLinkedList.push(200);
        stackUsingLinkedList.push(300);
        stackUsingLinkedList.push(400);
        stackUsingLinkedList.display();
        System.out.println();
        System.out.println("Pop:" + stackUsingLinkedList.pop());
        System.out.println("Peek:" + stackUsingLinkedList.peek());
        stackUsingLinkedList.display();


    }
}
