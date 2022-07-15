package com.algorithm.study.dynamic_programming;

/**
 * 188. 买卖股票的最佳时机 IV
 * 买卖股票dp通用解法，优化时间复杂度：时间复杂度O(n*k)   n*k/2，空间复杂度O(k)  2*k+1
 *
 * dp[i]同一行的每一列互相直接没有联系，它只与前一天的各列，即前一天的各个状态有关联。
 */
public class _25_MaxProfit_IV_2 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                //倒过来遍历，防止前一天的旧值被更新
                dp[j + 2] = Math.max(dp[j + 2], dp[j + 1] + prices[i]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] - prices[i]);
            }
        }

        return dp[2 * k];
    }
}
