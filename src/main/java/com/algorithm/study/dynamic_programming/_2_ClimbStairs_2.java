package com.algorithm.study.dynamic_programming;

/**
 * 70. 爬楼梯
 * dp:
 *      1、确定dp数组元素及其下标的含义
 *          dp[i]表示，爬到第i曾楼梯有dp[i]种方法
 *      2、确定状态转移方程
 *          爬到i-1楼有dp[i-1]种方法，再跳1个台阶就到i层，即在到达i-1楼的每种方法上最后加1，仍旧是dp[i-1]种方法
 *          爬到i-2楼有dp[i-2]种方法，再跳2个台阶就到i层，即在到达i-2楼的每种方法上最后加2，仍旧是dp[i-2]种方法
 *          所以：dp[i] = dp[i-1] + dp[i-2]
 *      3、确定dp数组如何初始化
 *          dp[1] = 1
 *          dp[2] = 2
 *      4、确定遍历顺序
 *          从前往后
 *      5、举例推导dp数组
 *          1 2 3 5 8
 *
 * dp：因为当前状态依赖前两个，可以使用滚动数组的思想做空间上的优化，用变量记录依赖值，只需要使用有限的额外空间。
 * dp：时间复杂度O(n)、空间复杂度O(1)
 */
public class _2_ClimbStairs_2 {

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
