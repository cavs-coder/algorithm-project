package com.algorithm.study.dynamic_programming;

/**
 * 377. 组合总和 Ⅳ
 * 背包遍历正序，物品可反复出现。
 *
 * 求组合数，外层遍历物品，内层遍历背包，最后得到的每个组合，里面的顺序都是nums[i]的顺序。因为当前num[i]被选中时，尾巴添加nums[i]是按外层循环顺序的。
 *          被选中时，数目等于dp[i - nums[j]]，此时i-nums[j]位置的每个组合，尾巴加个nums[i]就行了，数目不变。
 * 求排列数，外层遍历背包，内层遍历物品。当背包为i时，由于内循环是物品，可以反复添加，物品数组的顺序限制，能够出现各种组合。
 *          若是i>=nums[j]，dp[i] = dp[i] + dp[i - nums[j]]。dp[i - nums[j]]代表当前nums[i]被选中，
 *          此时i-nums[j]位置的每个组合，尾巴加个nums[i]就行了，数目不变，再加上nums[i]不被选中的数目dp[i]就得到当前排列数。
 *
 * dp：时间复杂度O(n*target)，空间复杂度O(target)
 */
public class _15_CombinationSum4_1 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < nums[j]) continue;
                dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }
}
