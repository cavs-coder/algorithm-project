package com.algorithm.study.dynamic_programming;

/**
 * 343. 整数拆分
 *      自顶向下的递归树，便于理解
 *                                                                      5
 *                                   1, 4                              2, 3                3, 2         4, 1
 *                   1, 1 3       1, 2 2       1, 3 1            2, 1 2   2, 2 1          3, 1 1
 *       1,1, 1 2    1,1, 2 1     1,2, 1 1                       2,1, 1 1
 *       1,1,1, 1 1
 *
 * 动态规划：
 *          1、确定dp数组元素及其下标的含义
 *              dp[i]表示：正整数i被拆分后的最大乘积
 *          2、确定状态转移方程
 *              j是第一个数，从1递增到i-1，当n为5时，它由第二层决定
 *              j=1时，考虑1*4更大还是1*dp[4]更大，1*4是两数相乘的积，它是本次循环新产生的组合，
 *              而dp[4]必定是至少两数相乘的积，它是历史数据的最大乘积,所以1*dp[4]是至少三数相乘的积，
 *              两个结果取较大值就得到j=1时当前产生的最大乘积dp[5]。当j=2、3、4分别计算后比较，就得到最终的dp[5]。
 *              所以：dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*(dp[i-j])))
 *          3、确定dp数组如何初始化
 *              由于j遍历到最后，j*(dp[i-j])=>j*(dp[1])，需要使用dp[1]，所以初始化dp[1],0和1都可以，保证它小于等于j*(i-j)，
 *              因为dp[1]本身并不存在含义，因为它无法按题意分解，所以初始化dp[1] = 0，即数组的构造初始化。
 *          4、确定遍历顺序
 *              dp自底向上，dp[i]依赖于dp[i-j]，1<=j<i，所以 0<i-j<i，所以从左往右遍历，j从1遍历到i-1
 *          5、举例推导dp数组
 *              n = 5
 *              下标       1  2  3  4  5
 *               dp[i]    0  1  2  4  6
 *
 *  dp：时间复杂度O(n^2)，空间复杂度O(n)
 */
public class _6_IntegerBreak_2 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        //dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
