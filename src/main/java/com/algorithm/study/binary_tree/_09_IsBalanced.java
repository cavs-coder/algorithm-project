package com.algorithm.study.binary_tree;

/**
 * 110. 平衡二叉树
 */
public class _09_IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
