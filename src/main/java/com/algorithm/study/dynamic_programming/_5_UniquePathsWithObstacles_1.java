package com.algorithm.study.dynamic_programming;

/**
 * 63. 不同路径 II
 * 关键点：遇到障碍，此路不通，上面和左面即使分别有a和b调路径，在障碍位置本来a+b清零，dp值变为0。
 *
 * dp：
 *      1、确定dp数组元素及其下标的含义
 *          dp[i][j] 表示 (0,0)到(i,j)有dp[i][j]条不同的路径
 *      2、确定状态转移方程
 *          dp[i][j] = dp[i-1][j] + dp[i][j-1]、遇到障碍物置为0、数组默认初始化为0
 *      3、确定dp数组如何初始化
 *          第一行和第一列都是直走一条路，初始化为1，若是遇到障碍物，障碍物及后续都应为0
 *      4、确定遍历顺序
 *          先左到右填充行，再上到下补满所有行
 *          先上到下填充列，再左到右补满所有列
 *          两种都可以。
 *      5、举例推导dp数组
 *          obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]，正中间一个障碍物
 *          dp[i][j] = [[1,1,1],
 *                      [1,0,1],
 *                      [1,1,2]]
 * dp：时间复杂度O(m*n)、空间复杂度O(m*n)
 */
public class _5_UniquePathsWithObstacles_1 {

    //先左到右填充行，再上到下补满所有行
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //第一个或者最后一个节点为障碍物，则不同的路径条数直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    //先左到右填充行，再上到下补满所有行
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //第一个或者最后一个节点为障碍物，则不同的路径条数直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
