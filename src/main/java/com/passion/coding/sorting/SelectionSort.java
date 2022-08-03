package com.passion.coding.sorting;

import java.util.Arrays;

public class SelectionSort {

    // find/select/find the minimum element in an array place it in order from beginning
    public static void sort(int[] arr){

        for(int i=0;i< arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){

                if(arr[min]>arr[j]){
                   min=j;
                }
            }
            if(min!=i){
                int temp = arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
            System.out.println("In Sorting:"+ Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int[] arr={8,9,5,1,4,7,6};
        System.out.println("Before sorting:"+ Arrays.toString(arr));
        sort(arr);
        System.out.println("After Sorting:"+Arrays.toString(arr));
    }
}
