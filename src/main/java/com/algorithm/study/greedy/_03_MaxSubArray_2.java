package com.algorithm.study.greedy;

/**
 * 53. 最大子数组和
 * 贪心、时间复杂度 O(n)、空间复杂度O(1)
 * 局部最优，推出全局最优。
 * 局部：总和不为负数的区间。
 * 若为负数时重置总和，分割为下一个局部。
 * 判断每一个局部的最大值，就能得到全局的最大值。
 */
public class _03_MaxSubArray_2 {

    //-2,1,-3,4,-1,2,1,-5,4
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            //每个区间和历史最大值比较，保留最大值
            maxSum = Math.max(maxSum, sum);
            //当区间总和为负数时重置总和为0，因为负数必定拉低总和。
            //区间从下一个索引位置开始，相当于重置最大字序起始位置
            sum = Math.max(sum, 0);
        }
        return maxSum;
    }
}
