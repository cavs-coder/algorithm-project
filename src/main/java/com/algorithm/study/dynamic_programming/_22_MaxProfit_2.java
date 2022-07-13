package com.algorithm.study.dynamic_programming;

/**
 * 121. 买卖股票的最佳时机
 * 贪心：时间复杂度O(n)，空间复杂度O(1)
 */
public class _22_MaxProfit_2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                //后续出现更小的min，若是继续往后遍历出现更大的利润 prices[i] - min，将会覆盖。
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }

        return maxProfit;
    }
}
