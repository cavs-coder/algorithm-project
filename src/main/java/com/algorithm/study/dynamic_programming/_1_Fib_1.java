package com.algorithm.study.dynamic_programming;

/**
 * 509. 斐波那契数
 * dp:
 *        1、确定dp数组元素及其下标的含义
 *           dp[i]代表第i个数的斐波那契数值
 *        2、确定动态规划转移方程
 *           状态转移方程：dp[i]=dp[i-1]+dp[i-2]
 *        3、确定dp数组如何初始化
 *           dp[0]=0
 *           dp[1]=1
 *        4、确定遍历顺序
 *           从递推公式可以看出dp[i]依赖dp[i-1]和dp[i-2]，所以应该从前往后遍历
 *        5、举例推导dp数组
 *           N = 5
 *           0 1 1 2 3 5
 *
 * dp:时间复杂度O(n)、空间复杂度O(n)
 */
public class _1_Fib_1 {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
