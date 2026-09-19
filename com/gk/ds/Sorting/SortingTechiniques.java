package com.gk.ds.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortingTechiniques {
    //start a loop from 0 to n 
    //for each i have an inner loop with j from i+1 to n find the minimum in this range 
    //swap the min with i
    //at the end u will have the requred sorted array
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("which sorting technique do u want o use:");
        System.out.println("Choose 1 for Selection sort");
        System.out.println("Choose 2 for bubbleSort");
        System.out.println("Choose 3 for insertionSort");
        int choice  = sc.nextInt();
        System.out.println("Enter the number of digits to be sorted:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println(String.format("Enter the %d of digits one my one to be sorted:",n));
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        switch(choice){
            case 1:selectionSort(arr);
            System.out.println("Sorted list using Selection sort is: ");
            case 2:bubbleSort(arr);
            System.out.println("Sorted list using Bubble sort is: ");
            case 3:insertionSort(arr);
            System.out.println("Sorted list using Bubble sort is: ");
            default:Arrays.sort(arr);
        }        
        
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
    //worst case time complexity is O(n*n)
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            for(int j =0 ; j<i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= tmp;
                }
            }
        }
    }
    //time conplexity is O(n*n)
    public static void insertionSort(int[] nums) {
        int n = nums.length; // Size of the array 
        
        // For every element in the array 
        for (int i = 1; i < n; i++) {
            int key = nums[i]; // Current element as key 
            int j = i - 1;
            
            // Shift elements that are greater than key by one position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            
            nums[j + 1] = key; // Insert key at correct position
        }
    }

}
