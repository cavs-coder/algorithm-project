package com.algorithm.study.dynamic_programming;

/**
 * 509. 斐波那契数
 * dp:
 *        1、确定dp数组以及下标的含义
 *           dp[i]代表第i个数的斐波那契数值
 *        2、确定递推公式
 *           状态转移方程：dp[i]=dp[i-1]+dp[i-2]
 *        3、dp数组如何初始化
 *           dp[0]=0
 *           dp[1]=1
 *        4、确定遍历顺序
 *           从递推公式可以看出dp[i]依赖dp[i-1]和dp[i-2]，所以应该从前往后遍历
 *        5、举例推导dp数组
 *           N = 5
 *           0 1 1 2 3 5
 *
 * dp：因为当前状态依赖前两个，所以可以做空间上的优化，用变量记录依赖值。
 * dp：时间复杂度O(n)、空间复杂度从数组的O(n)变为O(1)
 */
public class _1_Fib_2 {

    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
