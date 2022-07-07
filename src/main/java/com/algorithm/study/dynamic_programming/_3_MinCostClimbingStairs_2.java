package com.algorithm.study.dynamic_programming;

/**
 * 746. 使用最小花费爬楼梯
 * 根据题意：台阶的范围为下标 0 -> cost.length，cost.length为楼顶
 * 比如 cost = [1,100,1,1,1,100,1,1,100,1] 实际为 cost = [1,100,1,1,1,100,1,1,100,1,0] 最后面还有一个楼顶
 *
 * dp：
 *      1、确定dp数组元素及其下标的含义：dp[i]表示到达第i个台阶所需要的最小花费
 *      2、确定动态规划转移方程：dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])
 *      3、确定dp数组如何初始化：题意可从下标0或1开始爬楼梯，所以dp[0]=dp[1]=0
 *      4、确定遍历顺序：从递推公式可以看出依赖前两个状态，所以从前往后
 *      5、举例推导dp数组：
 *      i           0  1  2 3 4  5  6 7 8   9  10
 *      cost     = [1,100,1,1,1,100,1,1,100,1]
 *      newCost  = [1,100,1,1,1,100,1,1,100,1, 0] 0为楼顶
 *      dp       = [0, 0, 1,2,2, 3, 3,4,4,  5, 6]
 *
 * dp：因为当前状态依赖前两个，可以使用滚动数组的思想做空间上的优化，用变量记录依赖值，只需要使用有限的额外空间。
 * dp：时间复杂度O(n)、空间复杂度O(1)
 */
public class _3_MinCostClimbingStairs_2 {

    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int cur = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = cur;
        }
        return b;
    }
}
