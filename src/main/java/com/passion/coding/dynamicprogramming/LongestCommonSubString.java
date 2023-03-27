package com.passion.coding.dynamicprogramming;

public class LongestCommonSubString {

    public String lcs(String str1, String str2){

        if(str1 == null || str2 == null){
            return null;
        }
        int m= str1.length();
        int n=str2.length();
        int[][] dp = new int[m][n];
        int max=0,endIndex=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (str1.charAt(i) == str2.charAt(j)) {
                    if(i==0 || j==0){
                       dp[i][j]=1;
                    } else {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    if(max<dp[i][j]){
                        max=dp[i][j];
                        endIndex=i;
                    }
                }
            }
        }
        return str1.substring(endIndex-max+1,endIndex+1);
    }

    public int lcsLength(String str1, String str2){

        if(str1 == null || str2 == null){
            return 0;
        }
        int m= str1.length();
        int n= str2.length();
        int[][] dp = new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (str1.charAt(i) == str2.charAt(j)) {
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    } else {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    if(max<dp[i][j]){
                        max=dp[i][j];
                    }
                }
            }
        }
        return max;
    }

    static int lcsLengthWithRecursion(int i, int j, int count,String str1, String str2)
    {

        if (i == 0 || j == 0)
        {
            return count;
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1))
        {
            count = lcsLengthWithRecursion(i - 1, j - 1, count + 1, str1, str2);
        }

        int count1 = lcsLengthWithRecursion(i, j - 1, 0, str1, str2);

        int count2 = lcsLengthWithRecursion(i - 1, j, 0, str1, str2);

        count = Math.max(count,Math.max(count1,count2));

        return count;
    }

    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString =new LongestCommonSubString();
        //https://www.interviewbit.com/blog/longest-common-substring/#:~:text=The%20longest%20common%20substring%20is,str2%20using%20a%20nested%20loop.
        System.out.println(longestCommonSubString.lcs("AB0CXYZAY","XYZABCB"));
        System.out.println("P:"+longestCommonSubString.lcs("AB0CXYZAY","XYZABCB"));
        System.out.println("Length using DP:"+longestCommonSubString.lcsLength("ABCXYZAY","XYZABCB"));
        System.out.println("Length using Recursion:"+longestCommonSubString.lcsLengthWithRecursion("ABCXYZAY".length(), "XYZABCB".length(),0,"ABCXYZAY","XYZABCB"));
    }

    public String lcsP(String str1, String str2){
        if(str1== null || str2== null){
            return null;
        }
        int m= str1.length();
        int n= str2.length();
        int[][] dp= new int[m][n];
        int max=0,endIndex=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(str1.charAt(i)== str2.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    } else{
                        dp[i][j]=dp[i-1][j-1]+1;
                        if(dp[i][j]>max){
                            max=dp[i][j];
                            endIndex=i;
                        }
                    }
                }
            }
        }
        return str1.substring(max-endIndex+1,endIndex+1);
    }
}
