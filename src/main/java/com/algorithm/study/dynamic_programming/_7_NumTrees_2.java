package com.algorithm.study.dynamic_programming;

/**
 * 96. 不同的二叉搜索树
 * dp：
 *      1、确定dp数组元素及其下标的含义
 *          dp[i]表示：1到i为节点组成的二叉搜索树个数
 *      2、确定状态转移方程
 *          以节点1到节点n分别作为根结点，进行遍历，1<=j<=n。遍历到节点j作为根节点时，左子树有j -1个节点，右子树有n-j个节点。
 *          节点i的二叉树个数就会等于，以它的左孩子作为根节点继续递归得出的个数，乘以以它的右孩子作为根节点继续递归得出的个数。
 *          变量j遍历完1到n的每个根节点，累加它们的值，就得到了整数n的不同二叉搜索树个数。
 *          dp[i] += dp[j-1]*dp[i-j]
 *      3、确定dp数组如何初始化
 *          假设n=5时，j = 1时，左子树节点数为0，右子树节点数为4，根据以它的左孩子作为根节点继续递归得出的个数，
 *          乘以以它的右孩子作为根节点继续递归得出的个数此，即：dp[0] * dp[4]，种类为dp[4]，所以dp[0]要为1。
 *          dp[1]即左右子树为dp[0]*dp[0] = 1
 *      4、确定遍历顺序
 *          dp[i]依赖于dp[i-j]所以，从头开始遍历。
 *      5、举例推导dp数组
 *          正整数n     dp[i]
 *          0           1
 *          1           1
 *          2           2 = dp[0] * dp[1] + dp[1] * dp[0]
 *          3           5 = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0]
 *          4          14 = dp[0] * dp[3] + dp[1] * dp[2] + dp[2] * dp[1] + dp[3] * dp[0]
 *          5          43 = dp[0] * dp[4] + dp[1] * dp[3] + dp[2] * dp[2] + dp[3] * dp[1] + dp[4] * dp[0]
 * dp：时间复杂度O(n^2)，空间复杂度O(n)
 */
public class _7_NumTrees_2 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
