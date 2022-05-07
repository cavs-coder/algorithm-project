package com.algorithm.study.binary_tree;

/**
 * 450. 删除二叉搜索树中的节点
 * 递归
 * 左右字数都不为null，利用二叉搜索树特性，将删除节点node的左子树挂到node右子树最左节点的左子树上。
 * 和二叉树通用删除比起来，只需要操作一次。
 */
public class _26_DeleteNode_2 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }

                cur.left = root.left;
                return root.right;
            }
        }

        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);

        return root;
    }
}
