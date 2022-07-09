package com.algorithm.study.dynamic_programming;

/**
 * 96. 不同的二叉搜索树
 * 递归，自顶向下，缓存优化，时间复杂度O(n^2)，空间复杂度O(n)
 *          正整数n     dp[i]
 *          5          43 = dp[0] * dp[4] + dp[1] * dp[3] + dp[2] * dp[2] + dp[3] * dp[1] + dp[4] * dp[0]
 *          4          14 = dp[0] * dp[3] + dp[1] * dp[2] + dp[2] * dp[1] + dp[3] * dp[0]
 *          3           5 = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0]
 *          2           2 = dp[0] * dp[1] + dp[1] * dp[0]
 *          1           1
 *          0           1
 *  终止条件：
 *          假设n=5时，j = 1时，左子树节点数为0，右子树节点数为4，根据以它的左孩子作为根节点继续递归得出的个数，
 *          乘以以它的右孩子作为根节点继续递归得出的个数此，即：dp[0] * dp[4]，种类为dp[4]，所以dp[0]要为1。
 *          dp[1]即左右子树为dp[0]*dp[0] = 1
 * dp：时间复杂度O(n^2)，空间复杂度O(n)
 */
public class _7_NumTrees_1 {

    int[] res;

    public int numTrees(int n) {
        res = new int[n + 1];
        return traversal(n);
    }

    public int traversal(int n) {
        if (n == 0 || n == 1) return 1;
        if (res[n] != 0) return res[n];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += traversal(i - 1) * traversal(n - i);
        }
        res[n] = count;
        return count;
    }
}
