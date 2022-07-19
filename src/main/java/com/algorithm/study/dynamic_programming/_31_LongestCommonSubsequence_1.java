package com.algorithm.study.dynamic_programming;

/**
 * 1143. 最长公共子序列
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * dp：时间复杂度O(m*n)，空间复杂度O(m*n)
 *
 * dp[i][j]：text1下标[0,i-1]的子序列，与text2下标[0,j-1]的子序列，的最长公共子序列
 *      a   c   e
 *   0  0   0   0
 * a 0  1   1   1
 * b 0  1   1   1
 * c 0  1   2   2
 * d 0  1   2   2
 * e 0  1   2   3
 */
public class _31_LongestCommonSubsequence_1 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //当a[i - 1] != b[j - 1]，公共子序列长度至少为左上角的dp[i - 1][j - 1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
