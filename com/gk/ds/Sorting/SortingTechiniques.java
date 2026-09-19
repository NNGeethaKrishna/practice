package com.gk.ds.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortingTechiniques {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("which sorting technique do u want o use:");
        System.out.println("Choose 1 for Selection sort");
        System.out.println("Choose 2 for bubbleSort");
        System.out.println("Choose 3 for insertionSort");
        System.out.println("Choose 4 for mergeSort");
        int choice = sc.nextInt();

        System.out.println("Enter the number of digits to be sorted:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println(String.format("Enter the %d of digits one by one to be sorted:", n));
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        switch (choice) {
            case 1:
                selectionSort(arr);
                System.out.println("Sorted list using Selection sort is: ");
                break;
            case 2:
                bubbleSort(arr);
                System.out.println("Sorted list using Bubble sort is: ");
                break;
            case 3:
                insertionSort(arr);
                System.out.println("Sorted list using Insertion sort is: ");
                break;
            case 4:
                mergeSort(arr, 0, n - 1); // High index is n - 1
                System.out.println("Sorted list using merge sort is: ");
                break;
            default:
                Arrays.sort(arr);
                System.out.println("Sorted list using default sort is: ");
        }

        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%d ", arr[i]));
        }
        sc.close();
    }

    // Time complexity: O(n^2)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int jmin = i;
            int min = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    jmin = j;
                    min = arr[j];
                }
            }
            int tmp = arr[i];
            arr[i] = arr[jmin];
            arr[jmin] = tmp;
        }
    }

    // Worst case time complexity: O(n^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // Time complexity: O(n^2)
    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    // Time complexity: O(n log n)
    public static void mergeSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int mid = l + (h - l) / 2; // Fixed parenthesis
        mergeSort(arr, l, mid);      // Left half boundary fixed
        mergeSort(arr, mid + 1, h);  // Right half boundary fixed
        merge(arr, l, mid, h);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
