package com.passion.coding.dynamicprogramming;

public class CoinChangeProblem {
    public static int coinChange(int currentIndex, int target, int[] currencies, String pad) {
        if (target == 0) {
            System.out.println(pad);
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            int result = 0;
            for (int i = currentIndex; i < currencies.length; i++) {
                System.out.println("pad:"+pad+"target:"+target+"i:"+i);
                result += coinChange(i, target - currencies[i], currencies, pad + currencies[i] + ",");
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] currencies = {2,3,4};
        int amount = 8;
        System.out.println(" Combination count:"+coinChange(0,amount,currencies,""));
    }
}
