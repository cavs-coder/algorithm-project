package com.algorithm.study.dynamic_programming;

/**
 * 53. 最大子数组和
 *  dp优化空间复杂度：时间复杂度O(n)，空间复杂度O(1)
 *
 *  dp[i]：以nums[i]结尾的最大子数组和
 *  两个来源：若是以nums[i-1]结尾的最大子数组和 dp[i-1] > 0，则dp[i] = dp[i-1] + nums[i]。
 *           若是以nums[i-1]结尾的最大子数组和 dp[i-1] <= 0，此时前面的和为负数变成累赘，则起始下标变为当前i： dp[i] = nums[i]
 *
 *     0  1   2   3   4   5   6   7   8
 *     -2 1   -3  4   -1  2   1   -5  4
 *  dp -2 1   -2  4   3   5   6   1   5
 */
public class _33_MaxSubArray_2 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int last = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            last = Math.max(last + nums[i], nums[i]);
            max = Math.max(max, last);
        }

        return max;
    }
}
