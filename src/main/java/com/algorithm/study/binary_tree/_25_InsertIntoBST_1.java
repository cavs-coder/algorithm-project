package com.algorithm.study.binary_tree;

/**
 * 701. 二叉搜索树中的插入操作
 * 递归
 */
public class _25_InsertIntoBST_1 {

    TreeNode pre;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    private void insert(TreeNode node, int val) {
        if (node == null) {
            TreeNode newNode = new TreeNode(val);
            if (pre.val > val) {
                pre.left = newNode;
            } else {
                pre.right = newNode;
            }
            return;
        }
        pre = node;
        if (node.val > val) {
            insert(node.left, val);
        } else {
            insert(node.right, val);
        }
    }
}
