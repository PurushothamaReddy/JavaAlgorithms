package com.passion.coding.array;

public class Intersection {


    static int i, j, k, c = 0, w;

    public static void main(String[] args) {

        int[] x = {2, 5, 3, 7};
        int[][] a = {{2, 5}, {3, 7}};
        System.out.println("The first array is " + "  ");
        for (int i = 0; i < x.length; i++)
            System.out.print(x[i] + "  ");
        System.out.println("");
        int[] y = {5, 2, 9, 0, 1};
        System.out.println("The second array is " + "  ");
        for (int j = 0; j < y.length; j++)
            System.out.print(y[j] + "  ");
        System.out.println("");
        intersection(x, y);
    }


    static void intersection(int x[], int y[]) {
        int[] z = new int[x.length + y.length];
        for (i = 0; i < (x.length); i++) {
            for (j = 0; j < y.length; j++) {
                if (x[i] == y[j]) {
                    z[c] = x[i];
                    c++;
                } else
                    continue;

            }
        }
        System.out.println("Intersection of two  array is " + "  ");
        for (k = 0; k < c; k++) {
            System.out.print("  " + z[k] + " ");
        }
        System.out.println("            ");
    }

    private static void inter(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int k = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    c[k++] = a[i];
                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(c[k]);
        }
    }
}