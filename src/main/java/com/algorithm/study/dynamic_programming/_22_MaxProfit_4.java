package com.algorithm.study.dynamic_programming;

/**
 * 121. 买卖股票的最佳时机
 * dp：时间复杂度O(n)，空间复杂度O(1)，滚动数组优化空间复杂度
 *
 * dp[0]表示第i-1天持有股票所得的最多现金
 * dp[1]表示第i-1天不持有股票所得的最多现金
 *
 * 两个来源：昨天持有股票所得的最多现金，今天不操作；或者今天买入新的股票，取较大值
 * dp[0] = Math.max(dp[0], -prices[i])
 *
 * 两个来源：昨天不持有股票所得的最多现金，今天不操作；或者今天卖出股票，取较大值
 * dp[1] = Math.max(dp[1], price[i] + dp[0])
 */
public class _22_MaxProfit_4 {

    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //先计算dp[1]，防止先计算dp[0]，导致被覆盖
            dp[1] = Math.max(dp[1], prices[i] - dp[0]);
            dp[0] = Math.max(dp[0], -prices[i]);
        }

        return dp[1];
    }
}
