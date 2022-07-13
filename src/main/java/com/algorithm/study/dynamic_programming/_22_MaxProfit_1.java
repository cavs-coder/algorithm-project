package com.algorithm.study.dynamic_programming;

/**
 * 121. 买卖股票的最佳时机
 * 暴力法：时间复杂度O(n^2)，空间复杂度O(1)
 */
public class _22_MaxProfit_1 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length -1; i++){
            if(min <= prices[i]) continue;
            int cur = prices[i];
            int curProfit = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] > cur){
                    curProfit +=  prices[j] - cur;
                    cur = prices[j];
                }
            }
            min = prices[i];
            maxProfit = Math.max(maxProfit,curProfit);
        }

        return maxProfit;
    }
}
