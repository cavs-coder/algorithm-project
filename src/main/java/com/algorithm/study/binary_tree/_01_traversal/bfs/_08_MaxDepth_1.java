package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * DFS递归
 */
public class _08_MaxDepth_1 {

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        depthFirst(root, 0);
        return maxDepth;
    }

    private void depthFirst(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;
        maxDepth = Math.max(deep, maxDepth);
        depthFirst(node.left, deep);
        depthFirst(node.right, deep);
    }
}
