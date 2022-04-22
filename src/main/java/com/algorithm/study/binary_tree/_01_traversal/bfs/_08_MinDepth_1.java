package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

/**
 * 111. 二叉树的最小深度
 * 递归
 */
public class _08_MinDepth_1 {

    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getMinDepth(node.left);
        int rightDepth = getMinDepth(node.right);
        if (node.left == null && node.right != null) return rightDepth + 1;
        if (node.left != null && node.right == null) return leftDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
