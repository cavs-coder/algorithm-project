package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 状态转移方程：dp[j] = Math.min(dp[j], dp[j-nums[i] + 1)
 * 初始化dp[0]需要为0，其余为最大值才不会覆盖，因为dp[0]需要给每个j=coins[i]下标，初始化为0。
 * 若是dp[j - coins[i]] == max，则表明此下标元素未被更新为最小的1，因为coins中没有面值j - coins[i]大小的硬币，所以需要跳过，
 * 不然若是dp[j - coins[i]]=max，加1后会溢出，变最小Integer数。此时直接不用比较，直接跳过，因为dp[j]不管是max，或者是被更新过的较小的值，
 * 都可以直接不用更新。
 *
 * dp：时间复杂度O(n*amount)，空间复杂度O(amount)
 */
public class _16_CoinChange_1 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] == max) continue;
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
