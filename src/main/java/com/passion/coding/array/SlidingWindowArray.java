package com.passion.coding.array;
//
public class SlidingWindowArray {

    public static void main(String[] args) {
        int[] arr ={5, 7, 1, 4, 3, 6, 2, 9, 2 };
        int sum= getSum(arr,0,4);
        int max_sum=0;
        for(int i=1;i <= arr.length-5;i++) {
            sum-=arr[i-1];// subtract element to the left of curr window
            sum+=arr[i+4];// add last element in curr window
            max_sum =Math.max(sum,max_sum);
        }

        System.out.println(max_sum);
    }

    public static int getSum(int[] a, int i,int j){
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=a[k];
        }
        return sum;
    }

}
