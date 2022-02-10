package com.algorithm.study.sort;

import java.util.Arrays;

/**
 * 冒泡排序：比较两个相邻的元素，将值大的交换到右边
 *
 */
public class BubbleSort {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {22, 33, 0, 11, 98, 66, 78, 15, 30};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {

        //22, 33, 0, 11, 98
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
