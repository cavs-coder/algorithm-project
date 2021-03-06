package com.algorithm.study.dynamic_programming;

/**
 * 518. 零钱兑换 II
 * dp：时间复杂度O(n*amount)，空间复杂度O(amount)
 *
 * 求组合数，外层遍历物品，内层遍历背包，最后得到的每个组合，里面的顺序都是nums[i]的顺序。因为当前num[i]被选中时，尾巴添加nums[i]是按外层循环顺序的。
 *          被选中时，数目等于dp[i - nums[j]]，此时i-nums[j]位置的每个组合，尾巴加个nums[i]就行了，数目不变。
 * 求排列数，外层遍历背包，内层遍历物品。当背包为i时，由于内循环是物品，可以反复添加，物品数组的顺序限制，能够出现各种组合。
 *          若是i>=nums[j]，dp[i] = dp[i] + dp[i - nums[j]]。dp[i - nums[j]]代表当前nums[i]被选中，
 *          此时i-nums[j]位置的每个组合，尾巴加个nums[i]就行了，数目不变，再加上nums[i]不被选中的数目dp[i]就得到当前排列数。
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
