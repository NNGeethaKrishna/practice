package com.gk.ds.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    //1
    //11
    //121
    //1331
    //14641
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //formula for fibonacci series
        List<List<Integer>> fib = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        fib.add(first);
        fib.add(second);
        for(int i=2;i<n;i++){
            List<Integer> tmp = new ArrayList<>();
            List<Integer> prev = fib.get(i-1);
            int len = prev.size();
            tmp.add(1);
            for(int j = 1;j<len;j++){
                tmp.add(prev.get(j)+prev.get(j-1));
            }
            tmp.add(1);

            fib.add(tmp);
        }
        for(List<Integer> a : fib){
            for(int b:a){
                System.out.print(String.format("%d ", b));
            }
            System.out.println();
        }
    }
}
