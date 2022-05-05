package com.algorithm.study.binary_tree;

/**
 * 98. 验证二叉搜索树
 * 中序遍历BST
 */
public class _20_IsValidBST_1 {

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        boolean left = isValidBST(root.left);

        if (pre >= root.val) {
            return false;
        }
        pre = root.val;

        boolean right = isValidBST(root.right);
        return left && right;
    }
}
