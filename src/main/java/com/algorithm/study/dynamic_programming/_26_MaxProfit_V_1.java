package com.algorithm.study.dynamic_programming;

/**
 * 309. 最佳买卖股票时机含冷冻期(买卖股票的最佳时机 II的变形题)
 *
 * dp[i]同一行的每一列互相直接没有联系，它只与前一天的各列，即前一天的各个状态有关联。
 *
 * 第i天有三种状态：
 * |------------------------------|------------------------------|------------------------------|
 *  1、持有股票状态                2、不持有股票状态:当日卖出        3、不持有股票状态:冷冻期(卖出后一天)，及冷冻期后，尚未买入前
 *
 * dp[i][j]，第i天状态为j时，所剩的最多现金。
 *
 * 一、持有股票状态dp[i][0]：1、今天之前已买入，今天不操作，即dp[i - 1][0]。2、今天买入，即dp[i - 1][2] - prices[i]。
 *                         两者取较大值，所以：dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i])
 * 二、不持有股票状态:当日卖出[i][1]：前一天持有股票状态 + 当日股价，即 dp[i][1] = dp[i - 1][0] + prices[i]
 * 三、不持有股票状态:冷冻期(卖出后一天)，及冷冻期后，尚未买入前dp[i][2]：1、冷冻期，此时现金等于前一天卖出状态的金钱dp[i - 1][1]，
 *                         2、冷冻期后，尚未买入前，此时与前一日状态三保持一致 dp[i - 1][2]
 *                         所以：dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2])
 *
 * 初始化：dp[0][0] = -prices[0]，dp[0][1],dp[0][2]都为0
 *      0   1   2
 * 举例：最后取dp[4][1] = 3，代表的策略为第1天股价1买入，剩余现金-1；第二天股价2卖出，剩余现金1；
 *      第三天冷冻期，剩余现金1；第四天0买入，剩余现金1； 第五天2卖出，剩余现金3。
 * 1    -1  0   0
 * 2    -1  1   0
 * 3    -1  2   1
 * 0    1   -1  2
 * 2    1   3   2
 *
 * dp：时间复杂度O(n)，空间复杂度O(n)，n*3
 */
public class _26_MaxProfit_V_1 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }
}