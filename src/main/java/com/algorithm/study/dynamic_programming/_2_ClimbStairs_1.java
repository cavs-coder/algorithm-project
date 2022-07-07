package com.algorithm.study.dynamic_programming;

/**
 * 70. 爬楼梯
 * dp:
 *      1、确定dp数组以及下标含义
 *          dp[i]表示，爬到第i曾楼梯有dp[i]种方法
 *      2、确定递推公式
 *          爬到i-1楼有dp[i-1]种方法，再跳1个台阶就到i层，即在到达i-1楼的每种方法上最后加1，仍旧是dp[i-1]种方法
 *          爬到i-2楼有dp[i-2]种方法，再跳2个台阶就到i层，即在到达i-2楼的每种方法上最后加2，仍旧是dp[i-2]种方法
 *          所以：dp[i] = dp[i-1] + dp[i-2]
 *      3、确定dp数组如何初始化
 *          dp[1] = 1
 *          dp[2] = 2
 *      4、确定遍历顺序
 *          从前往后
 *      5、举例推导验证
 *          1 2 3 5 8
 *
 * dp：时间复杂度O(n)、空间复杂度O(n)
 */
public class _2_ClimbStairs_1 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
