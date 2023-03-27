package com.passion.coding.dynamicprogramming;

public class FibWithRecursionAndDp {

    public int fibWithDp(int n){
        int[] f= new int[n+1];
        f[0]=0;
        f[1]=1;
        for (int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
            System.out.println(f[i]);
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
        System.out.println(fib.fibWithRecursion(9));
        System.out.println(fib.fibWithDp(9));
        String s = "  abc  def\t";

        s = s.trim();

        System.out.println(s+"after");
    }

}
