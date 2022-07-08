package com.algorithm.study.dynamic_programming;

/**
 * 62. 不同路径
 * 二维数组：(1,1)=>(m,n)转化为(0,0)=>(m-1,n-1)
 * dp:
 *      1、确定dp数组元素及其下标的含义
 *         dp[i][j]代表(0,0)到(i,j)有dp[i][j]条不同的路径。
 *      2、确定状态转移方程
 *         因为机器人只能往下或往右走，所以只能从上或左边到dp[i][j]位置，即 dp[i][j] = dp[i-1][j] + dp[i][j-1]
 *      3、确定dp数组如何初始化
 *         因为(0,0)到(i,0)或者(0,j)位置都只有直走一条路径，所以第一行第一列的值都为1，即 dp[i][0] = 1，dp[0][j] = 1
 *      4、确定遍历顺序
 *         先左到右填充行，再上到下补满所有行
 *         先上到下填充列，再左到右补满所有列
 *         两种都可以。
 *      5、举例推导dp数组
 *         m = 3、n = 7
 *         1  1  1  1  1  1  1
 *         1  2  3  4  5  6  7
 *         1  3  6 10 15 21 28
 * dp：时间复杂度(m*n)，具体是(m-1)*(n-1)、空间复杂度O(m*n)
 */
public class _4_UniquePaths_2 {

    //先左到右填充行，再上到下补满所有行版本
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //先上到下填充列，再左到右补满所有列版本
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
