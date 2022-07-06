package com.algorithm.study.greedy;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 将手续费放在买入时考虑
 * 买入值bug初始值为prices[0]+手续费fee
 * i>0时，prices[i]有三个区间 (0，buy-fee)、[buy-fee,buy]、(buy，+∞)
 *
 * 贪心：
 *      局部：区间(0，buy-fee)为买入时机。
 *           区间[buy-fee,buy]既不是买入时机(会少赚)，也不是卖出时机(会亏本)，不操作。
 *           区间(buy，+∞)，卖出时机。利润profit = prices[i]-buy，此时已减去手续费（一次买入卖出，手续费只需要计算一次），是净利润。
 *           要注意的关键点是：下一天prices[i+1]仍可能继续上涨大于prices[i]，所以计算利润profit后，需要将buy赋值为prices[i],
 *           下一天的时候利润就是 prices[i+1] - buy = prices[i+1] - prices[i]，这是不包含手续费的利润，累加后正好为 prices[i+1]
 *           减掉最初的buy后的利润。比如[1,9,10]，手续费为2，buy=3，profit=9-3=6，buy=9，profit=10-9=1，利润累加profit=6+1=7。
 *      全局：局部的利润是那个区间最大的利润，累加后得到全局最大利润。
 * 时间复杂度O(n)、n为数组长度。空间复杂度O(1)
 */
public class _17_MaxProfit_1 {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buy = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }
            if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
