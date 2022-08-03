package com.passion.coding.linkedlist;


public class SingleLinkedList {

    Node head;

    class Node {
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

    public SingleLinkedList() {
        head = null;
    }

    public void insert(int data) {
        if (head == null) {
            head = new Node(data, null);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data, null);
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int delete(int data) {
        Node prev = head, temp = head.next;
        if (head.data == data) {
            head = head.next;
            prev = null;
            return data;
        } else {
            while (temp != null) {
                if (temp.data == data) {
                    prev.next = temp.next;
                    temp = null;
                    return data;
                }
                prev = temp;
                temp = temp.next;
            }
        }
        return -1;
    }

    public void reverse() {

        if (head.next == null) {
            return;
        } else {
            Node p = head, q = head.next;
            p.next = null;
            while (q != null) {
                p = q;
                q = p.next;
                p.next = head;
                head = p;
            }
        }
    }

    public Node reverse(Node headNode) {

        if (headNode.next == null) {
            return headNode;
        } else {
            Node p = headNode, q = headNode.next;
            p.next = null;
            while (q != null) {
                p = q;
                q = p.next;
                p.next = headNode;
                headNode = p;
            }
        }
        return headNode;
    }


    public int findMiddleElement() {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
    }

    public Node findMiddleNode() {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public int findNthElementFromEndOfList(int n) {
        Node slowPointer = head, fastPointer = head;
        while (n > 0 && fastPointer != null) {
            fastPointer = fastPointer.next;
            n--;
        }
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer.data;
    }

    public boolean detectLoopInLinkedList() {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    // Refer: https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/

    public int findFirstNodeInLinkedListLoop() {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                break;
            }
        }
        if(slowPointer == fastPointer){
            System.out.println("Loop Exist!");
            slowPointer = head;
            while (slowPointer!= fastPointer){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            return slowPointer.data;
        } else{
            System.out.println("NO LOOP Detected");
            return -1;
        }
    }

    public boolean isPalindrome(){
        Node temp =head;
        Node middleElement = findMiddleNode();

        Node secondHead = middleElement.next;
        middleElement.next =null;
        Node secondHalfReverse = reverse(secondHead);
        while(temp != null && secondHalfReverse != null){

            if(temp.data == secondHalfReverse.data){
                temp = temp.next;
                secondHalfReverse = secondHalfReverse.next;
                continue;
            } else{
                return false;
            }
        }
        return true;
    }

    public Node findIntersectionNode(Node list1, Node list2){
//        https://java2blog.com/intersection-two-linked-lists/

//        Find the length of both singly linked lists.
//        Find the bigger linked list and iterate up to the difference between two linked list.
//                Please note that two linked list will become equal at this step.
//                Iterate over both linked list and check if there is any common node, if you find one, return it.
//                Else return null.

        return null;
    }

    public Node reverseLinkedListInPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Lets take example of 5->6->7
        // Here head node is 5
        // Storing 6 in temp node, it will become our new head
        Node temp=head.next;
        // Putting link between 5->7
        head.next=temp.next;
        // putting link between 6->5
        temp.next=head;
        // recursively calling the function for node 7
        head.next= reverseLinkedListInPairs(head.next);
        // returning new head
        return temp;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.display();
        list.display( list.reverseLinkedListInPairs(list.head));
        list.delete(20);
        System.out.println("after delete");
        list.display();
        list.reverse();
        System.out.println("after reversal");
        list.display();
        list.insert(60);
        System.out.println("after insertion");
        list.display();
        System.out.println("Middle Element:" + list.findMiddleElement());
        System.out.println("Nth Element from the end: 2nd from th end" + list.findNthElementFromEndOfList(2));
        System.out.println("Is LoopExist:" + list.detectLoopInLinkedList());
        System.out.println("First element in loop:"+list.findFirstNodeInLinkedListLoop());

        SingleLinkedList list2 = new SingleLinkedList();
        list2.insert(1);
        list2.insert(2);
        list2.insert(1);
        list2.insert(2);
        list2.insert(1);

        System.out.println(" New List added");
        list2.display();
        System.out.println("Is New List palindrome: " +list2.isPalindrome());
        System.out.println("Is Old List palindrome: " +list.isPalindrome());

    }
}
