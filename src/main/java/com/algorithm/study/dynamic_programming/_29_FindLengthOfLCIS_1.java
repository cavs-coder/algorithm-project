package com.algorithm.study.dynamic_programming;

/**
 * 674. 最长连续递增序列
 * 贪心：时间复杂度O(n)，空间复杂度O(1)
 */
public class _29_FindLengthOfLCIS_1 {

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                len = 1;
                continue;
            }
            len++;

            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
}
