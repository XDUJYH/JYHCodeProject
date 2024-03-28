package com.jyh.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,1,4,2,7,3};
        sort(arr);
    }
    public static int[] sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            boolean flag = true;
            for(int j = 0; j < arr.length - i; j++){
                if(arr[j + 1] < arr[j]){
                   int tem = arr[j + 1];
                   arr[j + 1] = arr[j];
                   arr[j] = tem;
                   flag = false;
                }

            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
