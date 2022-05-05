package com.algorithm.study.binary_tree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 左闭右开
 */
public class _16_BuildTree_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return myBuildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode myBuildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inRight - inLeft == 0) {
            return null;
        }

        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }

        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);

        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inRight; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootVal) {
                break;
            }
        }

        root.left = myBuildTree(inorder, inLeft, delimiterIndex, postorder, postLeft, postLeft + (delimiterIndex - inLeft));
        root.right = myBuildTree(inorder, delimiterIndex + 1, inRight, postorder, postLeft + (delimiterIndex - inLeft), postRight - 1);

        return root;
    }

}
