package com.algorithm.study.binary_tree;

/**
 * 700. 二叉搜索树中的搜索
 * 递归
 */
public class _19_SearchBST_1 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode node = searchBST(root.left, val);
        if (node != null) {
            return node;
        }
        return searchBST(root.right, val);
    }
}
