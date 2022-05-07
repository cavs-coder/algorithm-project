package com.algorithm.study.binary_tree;

/**
 * 450. 删除二叉搜索树中的节点
 * 迭代
 * 左右字数都不为null，利用二叉搜索树特性，将删除节点node的左子树挂到node右子树最左节点的左子树上。
 * 和二叉树通用删除比起来，只需要操作一次。
 */
public class _26_DeleteNode_3 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == key) {
                break;
            }

            pre = cur;
            if (cur.val > key) cur = cur.left;
            else cur = cur.right;
        }

        if (pre == null) {
            return deleteOneNote(cur);
        }

        if (pre.left != null && pre.left.val == key) pre.left = deleteOneNote(cur);
        if (pre.right != null && pre.right.val == key) pre.right = deleteOneNote(cur);

        return root;
    }

    public TreeNode deleteOneNote(TreeNode node) {
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left != null && node.right == null) {
            return node.left;
        } else if (node.left == null && node.right != null) {
            return node.right;
        } else {
            TreeNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }

            cur.left = node.left;
            return node.right;
        }
    }
}
