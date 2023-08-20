package com.passion.coding.array;

public class MatrixTranspose {


    public static void transposeMatrix(int[][] a, int m, int n) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        int[][] temp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][i] = a[i][j];
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static int[][] add(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    /**
     * Method to calculate multiplication or product of two matrices.
     *
     * @param matrix1
     * @param matrix2
     * @return product of two matrix
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int columnsOfFirstMatrix = matrix1[0].length;
        int rowsOfSecondMatrix = matrix2.length;

        if (columnsOfFirstMatrix != rowsOfSecondMatrix) {
            throw new IllegalArgumentException(String.format("Can't multiply matrices, columns of first matrix"
                            + " %d is not equal to rows of second matrix %d",
                    columnsOfFirstMatrix, rowsOfSecondMatrix));
        }

        int rowsOfFirstMatrix = matrix1.length;
        int columnsofSecondMatrix = matrix2[0].length;
        int[][] product = new int[rowsOfFirstMatrix][columnsofSecondMatrix];

        for (int i = 0; i < rowsOfFirstMatrix; i++) {
            for (int j = 0; j < columnsofSecondMatrix; j++) {

                int sum = 0;
                for (int k = 0; k < rowsOfSecondMatrix; k++) {
                    sum = sum + matrix1[i][k] * matrix2[k][j];
                }

                product[i][j] = sum;
            }
        }

        return product;
    }


    public static void main(String args[]) {
        int m = 4, n = 5;
        int a[][] = {{1, 2, 3, 4, 10},
                {5, 6, 7, 8, 20},
                {1, 2, 3, 4, 30},
                {5, 6, 7, 8, 40}};
        transposeMatrix(a, m, n);
    }
}
