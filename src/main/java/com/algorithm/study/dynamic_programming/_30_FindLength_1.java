package com.algorithm.study.dynamic_programming;

/**
 * 718. 最长重复子数组
 * dp：时间复杂度O(m*n)，空间复杂度O(m*n)
 *
 * dp[i][i]：最长重复子数组，以nums1[i-1]为结尾，或者nums2[j-1]为结尾时，的最长重复子数组长度。
 *           若是nums1[i-1]==nums[j-1]时，dp[i][j] = dp[i-1][j-1] + 1
 * 二维数组纵向i为nums1，横向j为nums2，因为dp[i][j]依赖于dp[i-1][j-1]，所以i和j从1开始从上往下，从左往右遍历，
 * dp[i][0]和dp[0][j]没有意义，因为两数组元素要互相比较，所以i>=1，j>=1，并且把dp[i][0]和dp[0][j]初始化为0
 * 举例：
 *          3   2   1   4   7
 *      0   0   0   0   0   0
 *  1   0   0   0   1   0   0
 *  2   0   0   1   0   0   0
 *  3   0   1   0   0   0   0
 *  2   0   0   2   0   0   0
 *  1   0   0   0   3   0   0
 */
public class _30_FindLength_1 {

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
