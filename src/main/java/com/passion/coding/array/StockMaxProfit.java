package com.passion.coding.array;

public class StockMaxProfit {
    public static void main(String[] args) {
        int arr[]={14, 12, 70, 15, 99, 65, 21, 90};

        int lowestPriceTillDay=arr[0];
        int maxProfit=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int profit=0;
            //profit case
            if(arr[i]> lowestPriceTillDay){
                profit =arr[i]-lowestPriceTillDay;
                if( profit> maxProfit){
                    maxProfit=  profit;
                }
            } else {
                //if no profit this is lowest price
                lowestPriceTillDay=arr[i];
            }
        }
        System.out.println("Max Profit:"+maxProfit);
    }


    private static int maxProfit(int[] a){
        int lowestPriceTillToday=a[0];
        int profit=Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=1;i<a.length;i++){

            if(a[i] > lowestPriceTillToday){
                profit = a[i]-lowestPriceTillToday;
                if(profit>maxProfit){
                    maxProfit= profit;
                }
                } else {
                lowestPriceTillToday= a[i];
            }
        }
        return maxProfit;
    }
}
