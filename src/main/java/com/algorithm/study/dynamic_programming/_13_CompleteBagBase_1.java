package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 完全背包
 * 完全背包和01背包的区别就是一个物品可以多次放入，所以背包遍历顺序有差别，正序就行。
 */
public class _13_CompleteBagBase_1 {

    //先遍历物品，再遍历背包
    public void completeBag1(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[] dp = new int[w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = weight[i]; j <= w; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
    }

    //先遍历背包，再遍历物品
    public void completeBag2(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[] dp = new int[w + 1];
        for (int j = 0; j <= w; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
    }
}
