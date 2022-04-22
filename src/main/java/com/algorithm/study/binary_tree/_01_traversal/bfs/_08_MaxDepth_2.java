package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * DFS递归
 */
public class _08_MaxDepth_2 {

    public int maxDepth(TreeNode root) {
        return depthFirst(root);
    }

    private int depthFirst(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depthFirst(node.left);
        int rightDepth = depthFirst(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
