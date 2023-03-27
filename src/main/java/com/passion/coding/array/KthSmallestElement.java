package com.passion.coding.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int arr[]={10,5,20,8,3};
        int k=3;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k-1]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int a: arr) {
            priorityQueue.add(a);
        }
        while(priorityQueue.size()> arr.length-k+1) {
            priorityQueue.remove();
        }
        System.out.println(priorityQueue.peek());
    }
}
