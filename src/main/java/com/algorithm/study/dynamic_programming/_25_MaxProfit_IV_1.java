package com.algorithm.study.dynamic_programming;

/**
 * 188. 买卖股票的最佳时机 IV
 * 买卖股票dp通用解法：时间复杂度O(n*k)   n*k/2，空间复杂度O(n*k)    n*(2*k+1)
 */
public class _25_MaxProfit_IV_1 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }

        return dp[n - 1][2 * k];
    }
}
