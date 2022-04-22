package com.algorithm.study.binary_tree;

/**
 * 559. N 叉树的最大深度
 * dfs递归
 */
public class _07_N_MaxDepth_2 {

    int maxDepth = 0;

    public int maxDepth(Node root) {
        return getMaxDepth(root);
    }

    private int getMaxDepth(Node node) {
        if (node == null) return 0;
        int depth = 0;
        if (node.children != null) {
            for (Node child : node.children) {
                depth = Math.max(depth, getMaxDepth(child));
            }
        }
        //+1是处理当前层
        return depth + 1;
    }
}
