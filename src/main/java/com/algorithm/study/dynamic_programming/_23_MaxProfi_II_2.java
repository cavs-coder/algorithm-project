package com.algorithm.study.dynamic_programming;

/**
 * 122. 买卖股票的最佳时机 II
 * dp：时间复杂度O(n)、空间复杂度O(n),dp数组长度n，每个元素长度2，dp(2n) ===> dp(n)
 *
 * 每天只有两个状态：持有股票，不持有股票。
 * dp[i][0]：表示持有股票时余下的最大现金，不包含股票的股价。
 * dp[i][1]：表示不持有股票时所有的最大现金。
 *
 * dp[i][0]两个来源：1、第i天不操作(前一天持有股票时余下的最大现金，不包含股票的股价)，
 *                  2、第i天买入新的股票(前一天不持有股票的最大现金 - 第i天的股价prices[i])
 *                     两者取较大值。
 * dp[i][1]两个来源：1、第i天不操作(前一天不持有股票时所有的最大现金)，
 *                  2、第i天卖出持有股票(前一天持有股票时余下的最大现金，不包含股票的股价 + 第i天的股价prices[i])
 *                     两者取较大值。
 * dp[dp.length - 1][1]即代表第dp.length - 1天，不持有股票的最大现金，它必大于等于dp[dp.length - 1][0]。
 * dp[dp.length - 1][1]的值代表其中一种交易方案，可能不是dp.length - 1当天产生的值。
 */
public class _23_MaxProfi_II_2 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[dp.length - 1][1];
    }
}
