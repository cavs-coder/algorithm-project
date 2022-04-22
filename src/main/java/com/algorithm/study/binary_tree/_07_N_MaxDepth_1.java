package com.algorithm.study.binary_tree;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 * dfs递归
 */
public class _07_N_MaxDepth_1 {

    int maxDepth = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return maxDepth;
        }

        depthFirst(root, 0);
        return maxDepth;
    }

    private void depthFirst(Node node, int deep) {
        if (node == null) return;
        deep++;
        maxDepth = Math.max(maxDepth, deep);
        List<Node> children = node.children;
        if (children == null || children.size() == 0) {
            return;
        }
        for (Node child : children) {
            depthFirst(child, deep);
        }
    }
}
