package com.passion.coding.sorting;

import java.util.Arrays;

public class QuckSortFirstElement{

    public static void main(String[] args){
        int[] input ={10, 16, 8, 12, 15, 6, 3,9,5};
        System.out.println("Before sorting:" + Arrays.toString(input));
        quickSort(0, input.length-1, input);
        System.out.println("After Sorting:" + Arrays.toString(input));
    }

    protected static void quickSort(int start, int end, int[] a){
        if(start<end){
            int index=partition(start,end,a);
            quickSort(start,index-1,a);
            quickSort(index+1,end,a);
        }
        return;
    }

    protected static int partition(int start, int end, int[] a){
        int p = start;
        int i = start;
        int j= end;

        while (i < j){
            while(a[i] <= a[p] && i < end){
                i++;
            }
            while(a[j]> a[p] && j > start){
                j--;
            }
            if(i < j){
                swap(i,j,a);
            }
        }
        swap(j,p,a);
        return j;
    }

    private static void swap(int p1, int p2, int[] a){
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }

}