package com.gk.ds.Resursion;

import java.util.Scanner;

public class fibonacciSeries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        for(long i :dp)
        System.out.print(String.format("%d ", i));
        System.out.println();
        System.out.println(fib(n-1));
    }
    public static long fib(int n){
        if(n==0){
            return 0 ;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
