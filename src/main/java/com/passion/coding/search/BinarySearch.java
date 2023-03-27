package com.passion.coding.search;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {

        int start = 0, end = arr.length - 1;
        int index = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return index;
    }


    public static int binarySearchP(int[] arr, int key) {
        int start= 0;
        int end = arr.length-1;
        while (start<= end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            } else if(key< arr[mid]){
                end= mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;

    }
    public static int binarySearchP(int[] arr, int key, int start, int end){
        if(start> end){
            return -1;
        }
        int mid = (start+end)/2;
        if(arr[mid]== key){
            return mid;
        } else if(key <arr[mid]) {
            return binarySearchP(arr,key,start, mid-1);
        } else{
            return binarySearchP(arr,key,mid+1,end);
        }
    }


    public static int binarySearch(int[] arr, int key, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (key < arr[mid]) {
            return binarySearch(arr, key, low, mid - 1);
        } else {
            return binarySearch(arr, key, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,20,40,80,100,120};
        System.out.println("BS using Iteration: "+binarySearchP(arr,100));
        System.out.println("BS using Iteration: "+binarySearchP(arr,90));
        System.out.println("BS using Recursion: "+binarySearchP(arr,100,0,arr.length-1));
    }


}
