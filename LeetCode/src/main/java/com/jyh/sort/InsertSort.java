package com.jyh.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,1,4,2,7,3};
        sort(arr);
    }
    public static int[] sort(int[] arr){
        for(int i = 1; i < arr.length; i ++){
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }
}


