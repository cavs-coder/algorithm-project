package com.algorithm.study.binary_tree;

/**
 * 98. 验证二叉搜索树
 * 中序遍历BST
 */
public class _20_IsValidBST {

    long maxVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        boolean left = isValidBST(root.left);

        if (maxVal >= root.val) {
            return false;
        }
        maxVal = root.val;

        boolean right = isValidBST(root.right);
        return left && right;
    }
}
