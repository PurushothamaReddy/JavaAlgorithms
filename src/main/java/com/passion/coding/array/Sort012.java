package com.passion.coding.array;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {

//        /* Sorting in decreasing (descending) order*/
//        Collections.sort(arraylist, Collections.reverseOrder());
        int[] arr= {1,2,0,1,2,0,1,2,0};
        //TC O(N)

        sort012(arr, arr.length);
        for (int a:arr) {
            System.out.print(a+" ");
        }

//        a = a+ b; //now a is 30 and b is 20
//        b = a -b; //now a is 30 but b is 10 (original value of a)
//        a = a -b; //now a is 20 and b is 10, numbers are swapped


    }
    private static void sort012(int a[], int n){
        int l=0,m=0,h=n-1;
        while(m<=h){
            if(a[m]==0){
                int temp=a[m];
                a[m]=a[l];
                a[l]=temp;
                l++;
                m++;
            }
            else if(a[m]==1){
                m++;
            }else{
                int temp=a[m];
                a[m]=a[h];
                a[h]=temp;
                h--;
            }
        }
    }
}
