package com.algorithm.study.dynamic_programming;

/**
 * 121. 买卖股票的最佳时机
 * dp：时间复杂度O(n)，空间复杂度O(n)，dp数组长度n
 *
 * dp[i][0]表示第i天持有股票所得的最多现金
 * dp[i][1]表示第i天不持有股票所得的最多现金
 *
 * 两个来源：昨天持有股票所得的最多现金，今天不操作；或者今天买入新的股票，取较大值
 * dp[i][0] = Math.max(dp[i-1][0], -prices[i])
 *
 * 两个来源：昨天不持有股票所得的最多现金，今天不操作；或者今天卖出股票，取较大值
 * dp[i][1] = Math.max(dp[i-1][1], price[i] + dp[i-1][0])
 */
public class _22_MaxProfit_3 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[dp.length - 1][1];
    }
}
