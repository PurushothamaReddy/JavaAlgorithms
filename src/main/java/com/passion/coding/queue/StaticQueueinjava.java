package com.passion.coding.queue;

//Enqueue: Addition of an element to the queue.
// Adding an element will be performed after checking whether the queue is full or not.
// If rear < n which indicates that the array is not full then store the element at arr[rear] and increment rear by 1 but if rear == n then it is said to be an Overflow condition as the array is full.
//Dequeue: Removal of an element from the queue.
// An element can only be deleted when there is at least an element to delete i.e. rear > 0.
// Now, the element at arr[front] can be deleted but all the remaining elements have to shift to the left by one position in order for the dequeue operation to delete the second element from the left on another dequeue operation.
//Front: Get the front element from the queue i.e. arr[front] if the queue is not empty.
//Display: Print all elements of the queue.
// If the queue is non-empty, traverse and print all the elements from the index front to rear.
// Java program to implement a queue using an array
class Queue {
    static private int front, rear, capacity;
    static private int queue[];
 
    Queue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }
 
    // function to insert an element
    // at the rear of the queue
    static void queueEnqueue(int data)
    {
        // check queue is full or not
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }
 
        // insert element at the rear
        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }
 
    // function to delete an element
    // from the front of the queue
    static void queueDequeue()
    {
        // if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
 
        // shift all the elements from index 2 till rear
        // to the right by one
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
 
            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = 0;
 
            // decrement rear
            rear--;
        }
        return;
    }
 
    // print queue elements
    static void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
 
        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }
 
    // print front of queue
    static void queueFront()
    {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d",
                          queue[front]);
        return;
    }
}
 
public class StaticQueueinjava {
 
    // Driver code
    public static void main(String[] args)
    {
        // Create a queue of capacity 4
        Queue q = new Queue(4);
 
        // print Queue elements
        q.queueDisplay();
 
        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);
 
        // print Queue elements
        q.queueDisplay();
 
        // insert element in the queue
        q.queueEnqueue(60);
 
        // print Queue elements
        q.queueDisplay();
 
        q.queueDequeue();
        q.queueDequeue();
        System.out.printf(
            "\n\nafter two node deletion\n\n");
 
        // print Queue elements
        q.queueDisplay();
 
        // print front of the queue
        q.queueFront();
    }
}