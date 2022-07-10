package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 01背包理论基础：二维数组版本
 * q：有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 *    每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 *
 * dp:时间复杂度O(n^w)，空间复杂度O(w)
 *      1、确定dp数组元素及其下标的含义
 *          dp[j]表示：从下标为[0,i]的物品任意取1到i+1个物品，放进容量为j的背包里面的最大价值。
 *      2、确定状态转移方程
 *          两种来源：
 *                   第一种：当下标为i，并且当前背包重量j<weight[i]时，此物品装不进背包里面，所以当前value[i]用不上。
 *                          此时直接使用它正上方[j]的值就行了，即物品下标[0,i-1]时，在背包j处的策略即价值
 *                   第二种：当下标为i，并且当前背包重量j>=weight[i]时，表示此物品已经开始能够单独或者与别的物品一起加入背包。
 *                          dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
 *      3、确定dp数组如何初始化
 *          可以不用初始化，倒序也能计算i=0时的dp值，二维数组方式却必须要初始化i=0那一行，因为状态转移方程依赖于dp[i][j]依赖于dp[i-1][j]
 *          和dp[i-1][j-weight[i]] + value[i]
 *      4、确定遍历顺序
 *          先物品再背包容量，背包容量需倒序，正序先遍历到索引j - weight[i]的位置，会覆盖dp[j - weight[i]]值，倒置后面要用到dp[j - weight[i]]
 *          去计算dp值的时候不准确，一个背包加入了两次。
 *          先背包容量再物品不可以！因为，容量要倒序，比如j=w，遍历物品i=1，通过j - weight[i]计算dp[j]可以，因为i=0那一行已经被初始化，
 *          然后遍历物品i=2，此时想要通过j - weight[i]计算dp[j]不可以，因为i=1的dp[j - weight[i]]尚未经过计算。
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
public class _8_01BagBase_2 {

    public int bagBase01(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[] dp = new int[w + 1];

        for (int i = 0; i < n; i++) {
            for (int j = w; j >=weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);

            }
            System.out.println(Arrays.toString(dp));
        }


        return dp[w];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int w = 9;
        System.out.println(new _8_01BagBase_2().bagBase01(weight, value, w));
    }
}
