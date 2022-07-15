package com.algorithm.study.dynamic_programming;

/**
 * 714. 买卖股票的最佳时机含手续费
 * dp空间复杂度优化：时间复杂度O(n)，空间复杂度O(1)
 *
 * 手续费只需要计算一次，买入或者卖出计算都可以。
 *
 * 因为dp[i][0]不持有股票这一列是辅助列，都是为了记录前一列持有股票的最大现金，
 * prices[i]的一段递增区间[a,b]，dp[i][a] - dp[i][b]都会等于dp[i][a]，即记录了这段递增区间[a,b]的持有股票最大现金均为dp[i][a]。
 * 此值由递增区间最小边界索引a对应的区间最小股票值prices[a]，它与前一天(a-1天)的不持有股票最大现金经过计算得来。
 *
 * 1、买入时计算手续费：
 *      持有股票：
 *             1、之前持有股票的剩余现金更大，本次不操作，取dp[0]
 *             2、当日购入新的股票，需计算手续费dp[1] - prices[i] - fee
 *             两者取较大值，若是 dp[0] < dp[1] - prices[i] - fee，说明出现了新的买入时机，首次需要计算手续费
 *             即：dp[i][0] = Math.max(dp[0], dp[1] - prices[i] - fee);
 *      不持有股票：
 *             1、前一天就不持有股票了，取dp[1]
 *             2、当日卖出，前一天持有股票的现金（已计算手续费） + 今日股价（不用考虑手续费），取dp[0] + prices[i]
 *             即：dp[i][1] = Math.max(dp[1], dp[0] + prices[i]);
 * 2、卖出时计算手续费：
 *       持有股票：
 *            dp[i][0] = Math.max(dp[0], dp[1] - prices[i])
 *       不持有股票：
 *            dp[i][1] = Math.max(dp[1], dp[0] + prices[i] - fee);
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
public class _27_MaxProfit_IV_3 {

    public int maxProfit1(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0] - fee;

        int temp;
        for (int i = 1; i < prices.length; i++) {
            //买入时计算手续费
            temp = dp[0];
            dp[0] = Math.max(temp, dp[1] - prices[i] - fee);
            dp[1] = Math.max(dp[1], temp + prices[i]);
        }

        return dp[1];
    }

    public int maxProfit2(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];

        int temp;
        for (int i = 1; i < prices.length; i++) {
            //卖出时计算手续费
            temp = dp[0];
            dp[0] = Math.max(temp, dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], temp + prices[i] - fee);
        }

        return dp[1];
    }
}
