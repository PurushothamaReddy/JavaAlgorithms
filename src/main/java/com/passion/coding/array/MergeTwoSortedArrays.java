package com.passion.coding.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a={1,3,5,0,0};
        int[] b={2,4};
        int i=0,j=0;
        System.out.println("Before Merge"+Arrays.toString(a));
       while (i< a.length && j < b.length){
           if(a[i]<b[j]){
               i++;
           } else {
               swapRightFrom(a,i);
               a[i]=b[j];
               i++;
               j++;
           }
       }
//        swapRightFrom(a,1);
        System.out.println("After Merge"+Arrays.toString(a));
    }
    public static void swapRightFrom(int[] a,int k){
        for(int i=a.length-1;i>k;i--){
            a[i]=a[i-1];
        }
    }
}
