package com.algorithm.study.binary_tree;

/**
 * 226. 翻转二叉树
 * DFS递归(注意：递归中序不行、因为指针。中交换左右节点后，再处理右节点是原来的左节点，左节点处理两次)
 */
public class _01_InvertTree_1 {

    //前序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
