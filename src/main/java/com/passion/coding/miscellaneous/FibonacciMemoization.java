package com.passion.coding.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {

    private static Map<Integer, Integer> memoizeTable = new HashMap<>(); // O(1)

    public static int fib(int n){

        if( n == 0 ) return 0;
        if( n == 1 ) return 1;

        if( memoizeTable.containsKey(n) )
        {
//            System.out.println("Getting value from computed result for "+n);
            return memoizeTable.get(n);
        }

        int result = fib(n-1)+ fib(n-2);

//        System.out.println("Putting result in cache for "+n);
        memoizeTable.put(n, result);

        return result;

    }
    public static void main(String[] args) {
        System.out.println("Recursion:");
        for (int i=0;i<=10;i++){
            System.out.print(fib(i)+" ");
        }
        System.out.println();
        System.out.println("Iteration:");
        int a=0,b=1,sum;
        for (int i=0;i<=10;i++){
            System.out.print(a+" ");
            sum=a+b;
            a=b;
            b=sum;
        }
    }
}
