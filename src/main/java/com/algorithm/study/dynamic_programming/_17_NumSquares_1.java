package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * dp：时间复杂度O(√n * n)，空间复杂度O(n)
 */
public class _17_NumSquares_1 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        int value;
        for (int i = 1; i * i <= n; i++) {
            value = i * i;
            for (int j = value; j <= n; j++) {
                if (dp[j - value] == max) continue;
                dp[j] = Math.min(dp[j], dp[j - value] + 1);
            }
        }

        //必有值至少为1组合成n的长度
        return dp[n];
    }
}
