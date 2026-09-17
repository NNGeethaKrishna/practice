package com.gk.ds.Math;

public class GCD {
    //brute force approach
    public static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    //optimized approach
    public static int gcdOptimized(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdOptimized(b, a % b);
    }
    public static int findGcd(int a, int b) {
        while(a > 0 && b > 0) {
            // If a is greater than b,
            // subtract b from a and update a
            if(a > b) {
                // Update a to the remainder
                // of a divided by b
                a = a % b;
            }
            // If b is greater than or equal
            // to a, subtract a from b and update b
            else {
                // Update b to the remainder
                // of b divided by a
                b = b % a;
            }
        }
        // Check if a becomes 0,
        // if so, return b as the GCD
        if(a == 0) {
            return b;
        }
        // If a is not 0,
        // return a as the GCD
        return a;
    }
}
