package com.algorithm.study.array._2_double_pointer;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * // TODO: 2022/02/17 16:19 双指针法无思路，参考答案
 */
public class SortedSquares {

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(nums)));
    }

    /**
     * 双指针法: 数组有序，可能存在负数。最大值一定在数组两侧，选择双指针法，从数组末尾开始依次填充元素平方
     */
    public int[] sortedSquares(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int k = nums.length - 1;

        int[] result = new int[nums.length];

        while (l <= r) {
            int lSquare = nums[l] * nums[l];
            int rSquare = nums[r] * nums[r];
            if (lSquare < rSquare) {
                result[k] = rSquare;
                r--;
            } else {
                result[k] = lSquare;
                l++;
            }

            k--;
        }
        return result;
    }
}
