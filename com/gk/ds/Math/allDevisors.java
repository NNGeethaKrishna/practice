package com.gk.ds.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class allDevisors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1 ; i <=n ;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
    }
    public List<Integer> getDivisors(int N) {
        // Create a list to store divisors
        List<Integer> res = new ArrayList<>();

        // Loop from 1 to square root of N
        for (int i = 1; i * i <= N; i++) {
            // Check if i divides N
            if (N % i == 0) {
                // Add i to result
                res.add(i);

                // If N / i is different from i, add N / i too
                if (i != N / i) {
                    res.add(N / i);
                }
            }
        }

        // Return the list of divisors
        return res;
    }
}

