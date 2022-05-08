package com.algorithm.study.binary_tree;

/**
 * 669. 修剪二叉搜索树
 * 迭代法
 * 1、将root移到[low,high]范围内
 * 2、修建root左子树
 * 3、修建root右子树
 */
public class _27_TrimBST_2 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }

        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }

        return root;
    }
}
