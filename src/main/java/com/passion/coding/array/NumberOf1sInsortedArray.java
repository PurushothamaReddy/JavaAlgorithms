package com.passion.coding.array;

public class NumberOf1sInsortedArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{0,0,0,1,1,1}));
    }
    public static int solve(int[] arr) {
        int currPointer = 0;

        while (currPointer < arr.length) {
            if (arr[currPointer] == 1) {
                // as we have found our first one, we will stop here and
                // result would be (arr.length-currPinter)
                break;
            }
            // we will keep on increasing currPoniter as long as we are
            //encountering zeroes
            currPointer++;
        }

        return (arr.length - currPointer);

    }
}
