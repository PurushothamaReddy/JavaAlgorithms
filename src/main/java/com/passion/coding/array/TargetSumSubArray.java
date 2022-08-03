package com.passion.coding.array;

public class TargetSumSubArray {
    public static void main(String[] args) {

        int arr[] = {2, 3, 6, 4, 9, 0, 11};
        solve(arr, 9);
        System.out.println("=====================");
        solve(arr, 9);
    }

    public static void solve(int[] arr, int target) {
        for (int start = 0; start < arr.length; start++) {
            // initialize the sum of the current subarray to 0.
            int currSum = 0;
            for (int end = start; end < arr.length; end++) {
                // add every element of the current subarray
                // to the current running sum.
                currSum += arr[end];

                // print the starting and ending indices once we get
                // subarray with given sum
                if (currSum == target) {
                    System.out.println("starting index : " +
                            start + ", " + "Ending index : " + end);

                }

            }
        }
    }

    public static void solveEfficient(int[] arr, int target) {
        int start = 0, end = 0, currentSum = 0;

        while (start < arr.length && end <= arr.length) {

            if (currentSum == target) {
                System.out.println("start:" + start + " end:" + (end - 1));
                if (end < arr.length) {
                    currentSum += arr[end];
                }
                end++;
            } else {
                if (currentSum > target) {
                    currentSum -= arr[start];
                    start++;
                } else {
                    if (end < arr.length) {
                        currentSum += arr[end];
                    }
                    end++;
                }


            }

        }

    }
}
