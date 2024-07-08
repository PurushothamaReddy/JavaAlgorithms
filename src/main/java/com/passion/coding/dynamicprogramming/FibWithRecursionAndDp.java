package com.passion.coding.dynamicprogramming;

import java.math.BigInteger;

public class FibWithRecursionAndDp {

    public int fibWithDp(int n){
        int[] f= new int[n+1];
        f[0]=0;
        f[1]=1;
        for (int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
            //System.out.println(f[i]);
        }
        return f[n];
    }

    public BigInteger fibWithDpBigInteger(int n){
        BigInteger[] f= new BigInteger[n+1];
        f[0]=new BigInteger(0+"");
        f[1]=new BigInteger(1+"");
        for (int i=2;i<=n;i++){
            f[i]=f[i-1].add(f[i-2]);
            //System.out.println(f[i]);
        }
        return f[n];
    }

    public int fibWithRecursion(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        return fibWithRecursion(n-1)+fibWithRecursion(n-2);
    }

    public static void main(String[] args) {
        FibWithRecursionAndDp fib = new FibWithRecursionAndDp();
        //test fibanocci for with n value 10,46,300 and time taken should be with in 1 sec
        long start= System.currentTimeMillis();
        System.out.println(fib.fibWithDpBigInteger(300));
        long end= System.currentTimeMillis();
        System.out.println("time:"+(end-start));
//        long start1= System.currentTimeMillis();
//        System.out.println(fib.fibWithRecursion(300));
//        long end1= System.currentTimeMillis();
//        System.out.println("time1:"+(end1-start1));


    }

}
