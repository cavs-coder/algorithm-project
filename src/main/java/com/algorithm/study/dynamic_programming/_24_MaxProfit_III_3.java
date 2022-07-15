package com.algorithm.study.dynamic_programming;

/**
 * 123. 买卖股票的最佳时机 III
 * dp：优化空间复杂度，时间复杂度O(n)，空间复杂度O(1)
 *
 * dp[i]同一行的每一列互相直接没有联系，它只与前一天的各列，即前一天的各个状态有关联。
 *
 * dp[i][0]：不操作。
 * dp[i][1]：第一次买入剩余最大现金。
 *           两个来源：1、不操作，取前一天第一次买入剩余最大现金。2、当日i第一次买入，股价为prices[i]，
 *           取前一天不操作 - 当日股价，两者取较大值。
 *           即：dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
 * dp[i][2]：第一次卖出剩余最大现金。
 *           两个来源：1、不操作，取前一天第一次卖出剩余最大现金。2、当日i第一次卖出，股价为prices[i]，
 *           取前一天第一次买入剩余最大现金 + 当日股价。两者取较大值。
 *           即：dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i])
 * dp[i][3]：第二次买入剩余最大现金。
 *           两个来源：1、不操作，取前一天第二次买入剩余最大现金。2、当日i第二次买入，股价为prices[i]，
 *           取前一天第一次卖出剩余最大现金 - 当日股价，两者取较大值。
 *           即：dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i])
 * dp[i][4]：第二次卖出剩余最大现金。
 *           两个来源：1、不操作，取前一天第二次卖出剩余最大现金。2、当日i第二次卖出，股价为prices[i]，
 *           取前一天第二次买入剩余最大现金+ 当日股价，两者取较大值。
 *           即：dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i])
 *
 * 初始化dp[0][1]和dp[0][3]为0-prices[0]，可以看作是第一天经历了第一次买，第一次卖，第二次买，第二次卖四个阶段。
 *
 * dp[i][4] >= dp[i][2]，当存在两个不相同的递增区间时，dp[i][4] > dp[i][2]，当至多只有一个递增区间时，dp[i][4] = dp[i][2]
 */
public class _24_MaxProfit_III_3 {

    public int maxProfit(int[] prices) {
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //倒过来遍历，防止前一天的旧值被更新
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }

        return dp[4];
    }
}
