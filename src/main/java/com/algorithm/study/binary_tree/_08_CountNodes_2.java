package com.algorithm.study.binary_tree;

/**
 * 222. 完全二叉树的节点个数
 */
public class _08_CountNodes_2 {

    public int countNodes(TreeNode root) {
        return depthFirst(root);
    }

    private int depthFirst(TreeNode root) {
        if (root == null) return 0;

        int leftCount = depthFirst(root.left);
        int rightCount = depthFirst(root.right);
        return leftCount + rightCount + 1;
    }
}
