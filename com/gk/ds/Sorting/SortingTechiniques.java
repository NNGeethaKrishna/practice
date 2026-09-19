package com.gk.ds.Sorting;

import java.util.Scanner;

public class SortingTechiniques {
    //start a loop from 0 to n 
    //for each i have an inner loop with j from i+1 to n find the minimum in this range 
    //swap the min with i
    //at the end u will have the requred sorted array
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of digits to be sorted:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println(String.format("Enter the %d of digits one my one to be sorted:",n));
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.println("Sorted list is : ");
        for(int i =0;i<n;i++){
            System.out.print(String.format("%d ", arr[i]));
        }
        sc.close();
    }
    //time complexity is O(n*n)
    public static void selectionSort(int[] arr) {
        // Implementation here
        int n = arr.length;
        for(int i=0;i<n;i++){
            int jmin = i;
            int min = arr[i];
            for(int j = i+1;j<n;j++){
                if(arr[j]<min){
                    jmin=j;
                    min = arr[j];
                }
            }
            int tmp = arr[i];
            arr[i] = arr[jmin];
            arr[jmin]=tmp; 
        }
    }
    

}
