package com.algorithm.study.dynamic_programming;

/**
 * 392. 判断子序列
 * 转化为两字符串最长公共子序列的长度是否等于小字符串的长度
 * dp：时间复杂度O(n*m)，空间复杂度O(n*m)
 *
 * dp[i][j]：截取下标[0,i-1]的s，和截取下标[0,j-1]的t，两个字符串的最长公共子序列的长度
 */
public class _34_IsSubsequence_1 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        int sLen = sCh.length;
        int tLen = tCh.length;
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (sCh[i - 1] == tCh[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[sLen][tLen] == sLen;
    }
}
