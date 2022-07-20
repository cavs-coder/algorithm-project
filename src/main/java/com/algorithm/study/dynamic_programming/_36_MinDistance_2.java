package com.algorithm.study.dynamic_programming;

/**
 * 583. 两个字符串的删除操作
 * dp：时间复杂度O(mn)，空间复杂度O(mn)
 * dp[i][j]：截取word1下标[0,i-1]的字符串，截取word2下标[0,j-1]的字符串，想要达到两字符串相等，需要删除元素个数。
 *
 * 当s[i-1] == t[j-1]时，此时不需要新增删除元素个数，dp[i][j] = dp[i-1][j-1]。
 * 当s[i-1] != t[j-1]时，此时需要新增删除元素个数：
 *          1、s[i-1]是多余的，需要多删除一个元素s[i-1]，即dp[i-1][j] + 1。
 *          2、t[j-1]是多余的，需要多删除一个元素t[j-1]，即dp[i][j-1] + 1。
 *          3、s[i-1]和t[j-1]都是多余的，需要多删除两个元素，即dp[i-1][j-1] + 2。
 *          三种情况取最小值，即：Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1,dp[i-1][j-1] + 2)
 *
 * 初始化，dp[i][0]表示word2为空串，所以word1有几个就删除几个dp[i][0] = i
 *        dp[0][j]表示word1为空串，所以word2有几个就删除几个dp[0][j] = j
 */
public class _36_MinDistance_2 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }

        return dp[m][n];
    }
}
