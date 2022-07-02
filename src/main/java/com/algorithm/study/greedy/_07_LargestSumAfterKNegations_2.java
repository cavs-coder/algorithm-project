package com.algorithm.study.greedy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 贪心：时间复杂度O(n)、空间复杂度O(1)
 * 局部最优：绝对值大的负数转化为正数，当前数值最大。
 * 全局最优：绝对值大的负数转化为正数越多，数组总和越大
 * <p>
 * 不按照绝对值从大到小排序，会多一次排序
 */
public class _07_LargestSumAfterKNegations_2 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        //不按照绝对值从大到小排序，会多一次排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        //如果k还大于0，并且为奇数，反转数组最小的值
        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }

        //求总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
