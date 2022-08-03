package com.passion.coding.array;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr={1,4,6,3,2};
        int n= arr.length+1;
        int sum=0;
        for(int a: arr){
            sum+=a;
        }
        int totalSum=(n*(n+1))/2;
        System.out.println(totalSum-sum);
        duplicate(new int[]{1,2,3,2,4,5,6});
    }

    public static void duplicate(int[] arr){
        int n= arr.length-1;
        int sum=0;
        for(int a: arr){
            sum+=a;
        }
        int totalSum=(n*(n+1))/2;
        System.out.println(sum-totalSum);
    }
    static void printMultipleMissingElements(int arr[],
                                     int N)
    {

        // Initialize an array with zero
        // of size equals to the maximum
        // element in the array
        int[] b = new int[arr[N - 1] + 1];

        // Make b[i]=1 if i is present
        // in the array
        for(int i = 0; i < N; i++)
        {

            // If the element is present
            // make b[arr[i]]=1
            b[arr[i]] = 1;
        }

        // Print the indices where b[i]=0
        for(int i = arr[0]; i <= arr[N - 1]; i++)
        {
            if (b[i] == 0)
            {
                System.out.print(i + " ");
            }
        }
    }

}
