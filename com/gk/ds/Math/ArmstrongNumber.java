package com.gk.ds.Math;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num =n;
        int count =0;
        while(num>0){
            count++;
            num = num/10;
        }   
        num = n;
        int res =0;
        while(num>0){
            res+=Math.pow((num%10),count);
            num = num/10;
        }
        System.out.println(res==n);
    }
    
}
