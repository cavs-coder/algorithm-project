package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 674. 最长连续递增序列
 * dp：时间复杂度O(n)，空间复杂度O(n)
 */
public class _29_FindLengthOfLCIS_2 {

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                continue;
            }
            dp[i] = dp[i - 1] + 1;

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
