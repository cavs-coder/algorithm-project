package com.algorithm.study.binary_tree;

/**
 * 700. 二叉搜索树中的搜索
 * 递归，利用二叉搜索树左至右升序特点
 */
public class _19_SearchBST_3 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
