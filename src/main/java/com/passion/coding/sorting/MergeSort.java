package com.passion.coding.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
           int mid= (low+high)/2;
            sort(arr, low, mid );
            sort(arr, mid + 1, high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int[] arr, int low,int mid, int high) {
        int n1=mid-low+1;
        int n2=high-mid;
        int[] la=new int[n1];
        int[] ra= new int[n2];
        //temp arrays to store left and right arrays
        for(int i=0;i<n1;i++){
            la[i]=arr[low+i];
        }
        for(int i=0;i<n2;i++){
            ra[i]=arr[mid+1+i];
        }
        int k=low;
        int i=0,j=0;
        while (i<n1 && j<n2){
            if(la[i]<=ra[j]){
                arr[k]=la[i];
                i++;
            } else{
                arr[k]=ra[j];
                j++;
            }
            k++;
        }
        // any left elements in la
        while (i<n1){
           arr[k]=la[i];
           i++;
           k++;
        }
        // any left elements in ra
        while (j<n2){
            arr[k]=ra[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 16, 8, 12, 15, 6, 3,9,5};
        //https://www.javatpoint.com/merge-sort
        System.out.println("Before sorting:" + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("After Sorting:" + Arrays.toString(arr));
    }
}
