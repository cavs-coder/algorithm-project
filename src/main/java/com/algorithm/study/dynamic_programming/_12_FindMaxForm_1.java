package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 474. 一和零
 * 转化为01背包问题：每一个字符串视为装进背包的物品，i个0和j个1为背包的容量，此背包容量是个二维数组，边界分别为m和n。
 * 每个物品依次尝试加入背包，它的边界为当前字符串str的zeros个0，ones个1，对于物品来说，它只有选与不选的区别。
 * 当物品k尝试加入背包时：
 *      1、若是不选当前物品作为其中一个长度，那么使用上个物品得出的最大长度dp[i][j]。
 *      2、若是当前物品满足条件，可以被加入，即dp[i-zeros][j-ones]存在有意义时，i>=zeros&&j>=ones，则用上一个物品
 *          在位置i方向为i-zeros，j方向为j-ones得出组合的最大长度+1就行了，就是加上当前字符串str，若是能进循环，
 *          dp[i-zeros][j-ones]必有值，至少为0。取1，2更大的长度就行了，它们代表了不同的组合。
 *      dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1)
 *
 *      dp[i][j]的含义：物品k尝试加入背包，在i个0，j个1时，所能取得的最大子集的长度。
 *      初始化：因为是计算长度，所以初始化为0，所以递推的时候dp[i][j]不会被覆盖
 *      举例推导：
 *      ["10","0001","111001","1","0"]
 *
 * "10"尝试加入背包
 *      0  1  2  3
 *   0 [0, 0, 0, 0]
 *   1 [0, 1, 1, 1]
 *   2 [0, 1, 1, 1]
 *   3 [0, 1, 1, 1]
 *
 * "0001"尝试加入背包
 *      0  1  2  3
 *   0 [0, 0, 0, 0]
 *   1 [0, 1, 1, 1]
 *   2 [0, 1, 1, 1]
 *   3 [0, 1, 1, 1]
 *
 * "111001"进不了循环，"1"尝试加入背包
 *      0  1  2  3
 *   0 [0, 1, 1, 1]
 *   1 [0, 1, 2, 2]
 *   2 [0, 1, 2, 2]
 *   3 [0, 1, 2, 2]
 *
 * "0"尝试加入背包
 *      0  1  2  3
 *   0 [0, 1, 1, 1]
 *   1 [1, 2, 2, 2]
 *   2 [1, 2, 3, 3]
 *   3 [1, 2, 3, 3]
 */
public class _12_FindMaxForm_1 {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        int zeros;
        int ones;
        for (String str : strs) {
            zeros = 0;
            ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
                System.out.println(Arrays.toString(dp[i]));
            }

        }

        return dp[m][n];
    }
}
