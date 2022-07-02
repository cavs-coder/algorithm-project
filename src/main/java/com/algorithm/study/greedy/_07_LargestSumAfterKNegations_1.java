package com.algorithm.study.greedy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 贪心：时间复杂度O(n)、空间复杂度O(1)
 * 局部最优：绝对值大的负数转化为正数，当前数值最大。
 * 全局最优：绝对值大的负数转化为正数越多，数组总和越大
 * 关键点：根据绝对值大小倒序
 * <p>
 * Stream流操作效率低一些
 */
public class _07_LargestSumAfterKNegations_1 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        //按照绝对值从大到小排序
        nums = Arrays.stream(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        //如果k还大于0，并且为奇数，反转数组最小的值
        if (k % 2 == 1) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }

        //求总和
        return Arrays.stream(nums).sum();
    }
}
