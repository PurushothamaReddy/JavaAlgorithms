package com.passion.coding.array;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arr[peakElement(arr)]);

    }

    static int peakElement(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[0] > arr[1])
                    return (0);
            } else if (i == (n - 1)) {
                if (arr[n - 1] > arr[n - 2])
                    return (n - 1);
            } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return (i);
            }

        }
        return -1;
    }

    private static int peakElement(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (a[0] > a[1])
                    return 0;
            } else if (i == n - 1) {
                if (a[n - 1] > a[n - 2])
                    return n - 1;
            } else if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
