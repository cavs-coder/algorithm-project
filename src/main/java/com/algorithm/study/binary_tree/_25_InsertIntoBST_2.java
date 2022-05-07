package com.algorithm.study.binary_tree;

/**
 * 701. 二叉搜索树中的插入操作
 * 迭代
 */
public class _25_InsertIntoBST_2 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        TreeNode pre = root;
        while (cur != null) {
            pre = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        TreeNode newNode = new TreeNode(val);
        if (pre.val > val) {
            pre.left = newNode;
        } else {
            pre.right = newNode;
        }

        return root;
    }
}
