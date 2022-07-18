package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *  1、dp[i]表示数组下标为i时，以当前nums[i]为结尾的最长递增子序列长度
 *  2、j范围[0,i-1]，nums[i]与nums[0]~nums[i-1]进行比较，若是满足以当前nums[i]为结尾的最长递增子序列，
 *     则num[i] > num[j]，此时dp[i] = Math.max(dp[i],dp[j]+1)，其中dp[i]暂存了dp[j]+1的最大值
 *  3、每个数组元素nums[i]，最少本身是一个最长递增子序列，所以dp数组元素均初始化为1
 *  4、dp[i]依赖于dp[0]~dp[i-1]，所以从左向右遍历
 *  5、[0,1,0,3,2]
 *      0   1   0   3   2
 *  0   1   1   1   1   1
 *  1   1   2   1   1   1
 *  2   1   2   1   1   1
 *  3   1   2   1   3   1
 *  4   1   2   1   3   3
 *
 *  dp：时间复杂度O(n^2)，空间复杂度O(n)
 */
public class _28_LengthOfLIS_1 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
