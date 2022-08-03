package com.passion.coding.queue;

// Implement FIFO using circular single linked-list pointing qp to tail node
public class QueueUsingLinkedList {
    Node qp;

    public QueueUsingLinkedList() {
        this.qp = null;
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

    public void enqueue(int data){
        if (qp == null){
            qp = new Node(data,null);
            qp.next=qp;
        } else{
            Node tnew = new Node(data,null);
            tnew.next= qp.next;
            qp.next=tnew;
            qp=tnew;
        }
    }

    public void dequeue(){
        if (qp == null){
            System.out.println("No elements in POP");
        } else{
           Node temp= qp;
           temp = temp.next;
           qp.next=temp.next;
           temp=null;
        }
    }

    public void display(){
        Node temp = qp;

        do{
            temp=temp.next;
            System.out.print(" "+temp.data);
        }while (temp !=null && qp!=temp);
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.enqueue(10);
        queueUsingLinkedList.enqueue(20);
        queueUsingLinkedList.enqueue(40);
        queueUsingLinkedList.enqueue(30);
        queueUsingLinkedList.enqueue(50);
        queueUsingLinkedList.display();
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.display();
    }
}
