package com.passion.coding.array;

import java.util.Arrays;

public class RotateArrayByKSteps {
    public static void rotateArrayByKTimes(int[] a,int k){
        for(int j=0;j<k;j++){
        int temp=a[a.length-1];
        for(int i=a.length-1;i>0;i--){
            a[i]=a[i-1];
        }
        a[0] =temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("Before Rotate"+ Arrays.toString(nums));
        rotateArrayByKTimes(nums,k);
        System.out.println("After Rotate"+Arrays.toString(nums));
    }
}
