package com.algorithm.study.dynamic_programming;

/**
 * 122. 买卖股票的最佳时机 II
 * 贪心：时间复杂度O(n)、空间复杂度O(1)
 */
public class _23_MaxProfi_II_1 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i] - prices[i - 1], 0);
        }
        return sum;
    }
}
