package com.passion.coding.dynamicprogramming;

public class CountMatrixPaths {

//https://www.techiedelight.com/count-all-paths-matrix-from-first-cell-to-last-cell/
    // Top-down recursive function to count all paths from cell (m, n)
    // to the last cell (M-1, N-1) in a given `M × N` rectangular grid
    public  int countPaths(int m, int n, int M, int N)
    {
        // there is only one way to reach the last cell
        // when we are at the last row or the last column
        if (m == M - 1 || n == N - 1) {
            return 1;
        }

        return countPaths(m + 1, n, M, N)     // move down
                + countPaths(m, n + 1, M, N);     // move right
    }

    // Bottom-up function to count all paths from the first cell (0, 0)
    // to the last cell (M-1, N-1) in a given `M × N` rectangular grid
    public static int countPaths(int m, int n)
    {
        // `T[i][j]` stores the number of paths from cell (0, 0) to cell (i, j)
        int[][] T = new int[m][n];

        // There is only one way to reach any cell in the first column, i.e.,
        // to move down
        for (int i = 0; i < m; i++) {
            T[i][0] = 1;
        }

        // There is only one way to reach any cell in the first row, i.e.,
        // to move right
        for (int j = 0; j < n; j++) {
            T[0][j] = 1;
        }

        // fill `T[][]` in a bottom-up manner
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }

        // last cell of `T[][]` stores the count of paths from cell (0, 0) to
        // cell (i, j)
        return T[m-1][n-1];
    }


    public static void main(String[] args) {
        CountMatrixPaths countMatrixPaths = new CountMatrixPaths();

        // `M × N` matrix
        int M = 3;
        int N = 3;

        int k = countMatrixPaths.countPaths(0, 0, M, N);
        System.out.println("The total number of paths is " + k);

        int count = countPaths(M, N);
        System.out.println("The total number of paths is " + count);

        int countP = countPathsP(M, N);
        System.out.println("The total number of paths P is " + countP);
    }

    private static int countPathsP(int m,int n){
        int[][] dp= new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }

        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
