package com.algorithm.study.dynamic_programming;

/**
 * 53. 最大子数组和
 *  dp：时间复杂度O(n)，空间复杂度O(n)
 *
 *  dp[i]：以nums[i]结尾的最大子数组和
 *  两个来源：若是以nums[i-1]结尾的最大子数组和 dp[i-1] > 0，则dp[i] = dp[i-1] + nums[i]。
 *           若是以nums[i-1]结尾的最大子数组和 dp[i-1] <= 0，此时前面的和为负数变成累赘，则起始下标变为当前i： dp[i] = nums[i]
 *
 *     0  1   2   3   4   5   6   7   8
 *     -2 1   -3  4   -1  2   1   -5  4
 *  dp -2 1   -2  4   3   5   6   1   5
 */
public class _33_MaxSubArray_1 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
