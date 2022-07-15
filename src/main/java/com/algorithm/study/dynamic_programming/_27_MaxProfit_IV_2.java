package com.algorithm.study.dynamic_programming;

/**
 * 714. 买卖股票的最佳时机含手续费
 * dp：时间复杂度O(n)，空间复杂度O(n)
 *
 * 手续费只需要计算一次，买入或者卖出计算都可以。
 *
 * 因为dp[i][0]不持有股票这一列是辅助列，都是为了记录前一列持有股票的最大现金，
 * prices[i]的一段递增区间[a,b]，dp[i][a] - dp[i][b]都会等于dp[i][a]，即记录了这段递增区间[a,b]的持有股票最大现金均为dp[i][a]。
 * 此值由递增区间最小边界索引a对应的区间最小股票值prices[a]，它与前一天(a-1天)的不持有股票最大现金经过计算得来。
 *
 * 1、买入时计算手续费：
 *      持有股票：
 *             1、之前持有股票的剩余现金更大，本次不操作，取dp[i - 1][0]
 *             2、当日购入新的股票，需计算手续费dp[i - 1][1] - prices[i] - fee
 *             两者取较大值，若是 dp[i - 1][0] < dp[i - 1][1] - prices[i] - fee，说明出现了新的买入时机，首次需要计算手续费
 *             即：dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
 *      不持有股票：
 *             1、前一天就不持有股票了，取dp[i - 1][1]
 *             2、当日卖出，前一天持有股票的现金（已计算手续费） + 今日股价（不用考虑手续费），取dp[i - 1][0] + prices[i]
 *             即：dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
 * 2、卖出时计算手续费：
 *       持有股票：
 *            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i])
 *       不持有股票：
 *            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
 *
 *      0   1
 *  2   -4  0
 *  1   -3  0
 *  4   -3  1
 *  8   -3  5
 *  3   0   5
 *  6   0   6
 *
 *  2   -2  0
 *  1   -1  0
 *  4   -1  1
 *  8   -1  5
 *  3   0   5
 *  6   0   6
 */
public class _27_MaxProfit_IV_2 {

    public int maxProfit1(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            //买入时计算手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[dp.length - 1][1];
    }

    public int maxProfit2(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //卖出时计算手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[dp.length - 1][1];
    }
}
