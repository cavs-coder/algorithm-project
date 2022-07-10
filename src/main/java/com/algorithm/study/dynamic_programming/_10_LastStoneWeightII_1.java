package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 * 关键点：将这堆石头分割成重量相近或相等的两堆时，相撞之后剩下的手头重量最小
 *
 * 其中一堆小于等于target的石头堆总重为dp[target]，
 * 另一批石头堆的总重即为sum - dp[target]，又因为sum/2向下取整，sum/2>=target  ===>  sum>=2target  ===>  sum-target>=target
 * 又因为[1,target]石头堆的：总质量dp[target]=总重量<=背包容量target，所以dp[target] <= target，
 * 结合上面：sum>=2target>=2dp[target]  ===> sum-dp[target]>=dp[target]，即后一堆石头总质量必定大于等于前面一堆。
 */
public class _10_LastStoneWeightII_1 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return sum - dp[target] - dp[target];
    }
}
