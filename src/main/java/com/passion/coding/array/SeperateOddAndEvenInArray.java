package com.passion.coding.array;

import java.util.Arrays;

public class SeperateOddAndEvenInArray {
    public static void main(String[] args) {
        int arr[]={12, 17, 70, 15, 22, 65, 21, 90};
        int low=0,high=arr.length-1;
        System.out.println(Arrays.toString(arr));
        while (low<=high){
            if( arr[low]%2 ==0) {
                low++;
            } else if( arr[high]%2 ==1) {
                high--;
            } else {
                int temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                low++;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
