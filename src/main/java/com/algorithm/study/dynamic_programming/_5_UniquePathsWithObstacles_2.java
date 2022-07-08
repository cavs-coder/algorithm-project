package com.algorithm.study.dynamic_programming;

/**
 * 63. 不同路径 II
 * 空间复杂度优化版本
 *
 * 关键点：遇到障碍，此路不通，上面和左面即使分别有a和b调路径，在障碍位置本来a+b清零，dp值变为0。
 *
 * dp：时间复杂度(m*n)，具体是(m-1)*(n-1)、空间复杂度O(n)
 *      1、确定dp数组元素及其下标的含义
 *          dp[j]代表同一行(i,0)到(i,j)，有dp[j]条不同的路径。
 *      2、确定状态转移方程
 *          dp[j] = dp[j] + dp[j-1]
 *      3、确定dp数组如何初始化
 *          j在[1,n-1]范围内，第一行只有直走一条路，初始化为1，若是遇到障碍物，障碍物及后续都应为 0
 *          j为0时，表示的时第一列 i在[1,m-1]范围内的代表直走一条路的 1，若是碰上障碍物需要更新为0
 *      4、确定遍历顺序
 *          先左到右填充行，再上到下补满所有行
 *      5、举例推导dp数组
 *          obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]，正中间一个障碍物
 *          dp[i][j] = [[1,1,1],
 *                      [1,0,1],
 *                      [1,1,2]]
 *          dp[j] => [1,1,1]
 *                => [1,0,1]
 *                => [1,1,2]
 */
public class _5_UniquePathsWithObstacles_2 {

    //dp：时间复杂度(m*n)，具体是(m-1)*(n-1)、空间复杂度O(n)
    //先左到右填充行，再上到下补满所有行，
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        //第一个或者最后一个节点为障碍物，则不同的路径条数直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            //首节点dp[0]路径数不是固定的1，需要动态变化，若是第一列碰到障碍物，则把首节点更新为0
            if (obstacleGrid[i][0] == 1) dp[0] = 0;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

    //dp：时间复杂度(m*n)，具体是(m-1)*(n-1)、空间复杂度O(m)
    //先左到右填充行，再上到下补满所有行
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[m];

        //第一个或者最后一个节点为障碍物，则不同的路径条数直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            //首节点dp[0]路径数不是固定的1，需要动态变化，若是第一行碰到障碍物，则把首节点更新为0
            if (obstacleGrid[0][j] == 1) dp[0] = 0;
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i] + dp[i - 1];
                }
            }
        }

        return dp[m - 1];
    }
}
