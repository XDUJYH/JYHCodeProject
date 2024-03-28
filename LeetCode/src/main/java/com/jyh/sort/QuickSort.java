package com.jyh.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,1,4,2,7,3};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            sort(array, low, position - 1);
            sort(array, position + 1, high);
        }
    }

}
