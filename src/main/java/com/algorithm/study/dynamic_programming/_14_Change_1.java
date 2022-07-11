package com.algorithm.study.dynamic_programming;

/**
 * 518. 零钱兑换 II
 * dp：时间复杂度O(n*amount)，空间复杂度O(amount)
 */
public class _14_Change_1 {

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
