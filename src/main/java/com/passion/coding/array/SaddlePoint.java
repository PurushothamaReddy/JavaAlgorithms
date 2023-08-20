package com.passion.coding.array;

public class SaddlePoint {

    public static void printSaddlePoint(int[][] a, int m, int n) {

        for (int i = 0; i < m; i++) {
            int min = a[i][0];
            int colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (min > a[i][j]) {
                    min = a[i][j];
                    colIndex = j;
                }

            }
            int max = a[i][colIndex];
            for (int k = 0; k < m; k++) {
                if (max < a[k][colIndex]) {
                    max = a[k][colIndex];
                }
            }
            if (min == max) {
                System.out.println("Saddle Point:" + min);
                return;
            }

        }


    }

    public static void main(String[] args) {
        int m = 4, n = 5;
        int a[][] = {{1, 2, 3, 4, 10},
                {5, 6, 7, 8, 20},
                {1, 2, 3, 4, 30},
                {5, 6, 7, 8, 40}};
        printSaddlePoint(a, m, n);
    }
}
