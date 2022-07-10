package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 01背包理论基础：二维数组版本
 * q：有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 *    每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 *
 * dp:时间复杂度O(n^w)，空间复杂度O(n^w)
 *      1、确定dp数组元素及其下标的含义
 *          dp[i][j]表示：从下标为[0,i]的物品任意取1到i+1个物品，放进容量为j的背包里面的最大价值。
 *      2、确定状态转移方程
 *          两种来源：
 *                   第一种：当下标为i，并且当前背包重量j<weight[i]时，此物品装不进背包里面，所以当前value[i]用不上。
 *                          此时直接使用它正上方dp[i-1][j]的值就行了，即物品下标[0,i-1]时，在背包j处的策略即价值
 *                   第二种：当下标为i，并且当前背包重量j>=weight[i]时，表示此物品已经开始能够单独或者与别的物品一起加入背包。
 *                          j-weight[i] >= 0，所以已经求得结果的dp[i-1][j-weight[i]]表示物品下标[0,i-1]时，在背包j-weight[i]处的策略即价值。
 *                          所以物品下标[0,i-1]在j=j-weight[i]处物品组合成的最大价值，加上物品i的价值即为当前位置可能的最大价值。
 *                          即：dp[i-1][j-weight[i]]+value[i]。但是由于物品组合多样，这个值仍需与它正上方dp[i-1][j]相比较，所以：
 *                          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
 *      3、确定dp数组如何初始化
 *          二维数组方式必须要初始化i=0那一行，因为状态转移方程依赖于dp[i][j]依赖于dp[i-1][j]和dp[i-1][j-weight[i]] + value[i]
 *          第一行判断j与weight[0]，大于等于的初始化为第一个物品的价值value[0]
 *          第一列初始化为0，背包容量为0，全都放不进去，价值均为0
 *      4、确定遍历顺序
 *          先物品再背包容量，或者先背包容量再物品都可以。
 *      5、举例推导dp数组
 *          n = 3, weight={1,3,4}, value={15,20,30}, w = 8
 *          纵坐标为物品i，横坐标为背包重量j
 *          横纵坐标  0   1    2    3    4    5    6    7    8
 *
 *               0   0   15   15   15   15   15   15   15   15
 *               1   0   15   15   20   35   35   35   35   35
 *               2   0   15   15   20   35   45   45   50   65
 *          很明显，当j=1+3+4=8时取得最大价值，所以举例子，举的w=8
 *          当i=0，j=1，达到物品1在背包中的最大价值
 *          当i=1，j=4，达到物品1，物品2在背包中的最大价值
 *          当i=2，j=8，达到物品1，物品2，物品3在背包中的最大价值
 */
public class _8_01BagBase_1 {

    public int bagBase01(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[][] dp = new int[n][w + 1];
        for (int j = 0; j <= w; j++) {
            if (j < weight[0]) continue;
            dp[0][j] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                //当前物品无法加入此前的物品组合成的最大价值的策略，直接使用正上方的
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n - 1][w];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int w = 9;
        System.out.println(new _8_01BagBase_1().bagBase01(weight, value, w));
    }
}
