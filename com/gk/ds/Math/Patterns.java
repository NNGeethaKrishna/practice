package com.gk.ds.Math;

import java.util.Scanner;

public class Patterns {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows for the pyramid:");
        int n = sc.nextInt();
        Patterns r = new Patterns();
        r.printPyramid(n);
        r.numberBox(n);
    }
    public void printPyramid(int n){
        int w = n*2 -1 ;
        for(int i=0;i<n;i++){
            int stars = 2*i + 1;
            int spaces = (w - stars)/2;
            for(int j=0;j<spaces;j++){
                System.out.print(" ");
            }
            for(int j=0;j<stars;j++){
                System.out.print("*");
            }
            for(int j=0;j<spaces;j++){
                System.out.print(" ");
            }
            System.out.println();

        }
    }
    public void numberBox(int n){
        int[][] box = new int[n][n];
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int min = Math.min(Math.min(i,j),Math.min(2*n-2-i,2*n-2-j));
                System.out.print(n-min + " ");
            }
            System.out.println();

        }
    }
}
