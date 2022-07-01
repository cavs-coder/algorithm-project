package com.algorithm.study.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 * 局部最优：收集每个正利润
 * 全局最优：每个正利润组成最大利润
 * 贪心：时间复杂度O(n)、空间复杂度O(1)
 */
public class _04_MaxProfit_1 {

    //7,1,5,3,6,4
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i] - prices[i - 1], 0);
        }
        return sum;
    }
}
