package com.algorithm.study.dynamic_programming;

/**
 * 53. 最大子数组和
 *  贪心：时间复杂度O(n)，空间复杂度O(1)
 *
 *  两个来源：若是以nums[i-1]结尾的最大子数组和 sum > 0，则sum = sum + nums[i]。
 *           若是以nums[i-1]结尾的最大子数组和 sum <= 0，此时前面的和为负数变成累赘，则起始下标变为当前i： sum = 0 + nums[i]
 *
 *     0  1   2   3   4   5   6   7   8
 *     -2 1   -3  4   -1  2   1   -5  4
 *  dp -2 1   -2  4   3   5   6   1   5
 */
public class _33_MaxSubArray_3 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            //sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
