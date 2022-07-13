package com.algorithm.study.dynamic_programming;

import com.algorithm.study.binary_tree.TreeNode;

/**
 * 337. 打家劫舍 III
 * 树形dp
 * 维护一个dp数组，下标0对应的dp[0]表示不偷该节点时的最大偷窃金钱，
 *                下标1对应的dp[1]表示偷该节点时的最大偷窃金钱。
 *
 *  偷当前节点：当前节点+不偷左子树的最大金钱+不偷右子树的最大金钱
 *  dp[1] = cur.val + left[0] + right[0]
 *
 *  不偷当前节点：当前节点左子树不偷与偷本节点值的较大者 + 当前节点右子树不偷与偷本节点值的较大者
 *  dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1])
 *
 *  树形dp，时间复杂度O(n)，空间复杂度O(n)，n为节点个数，平衡二叉树空间复杂度为O(logn), 最大n = 2^k-1 ，k为1开始的深度
 */
public class _21_Rob3_2 {

    public int rob(TreeNode root) {
        int[] dp = robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] robTree(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = robTree(node.left);
        int[] right = robTree(node.right);

        //偷当前节点
        int val1 = node.val + left[0] + right[0];

        //不偷当前节点
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{val2, val1};
    }
}
