package com.algorithm.study.dynamic_programming;

/**
 * 583. 两个字符串的删除操作
 * （1143. 最长公共子序列变形题）
 * dp：时间复杂度O(mn)，空间复杂度O(mn)
 * 转化成两个字符串最长公共子序列长度maxLen，然后两个字符串各减去maxLen，即得到需要的删除操作步数。
 */
public class _36_MinDistance_1 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int maxLen = dp[m][n];
        return m - maxLen + n - maxLen;
    }
}
