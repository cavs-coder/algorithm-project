package com.algorithm.study.binary_tree;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 左闭右开
 */
public class _15_BuildTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    private TreeNode myBuildTree(int[] inorder, int inL, int inR, int[] preorder, int preL, int preR) {

        if (inR - inL == 0) {
            return null;
        }

        if (inR - inL == 1) {
            return new TreeNode(inorder[inL]);
        }

        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);

        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inR; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootVal) {
                break;
            }
        }

        root.left = myBuildTree(inorder, inL, delimiterIndex, preorder, preL + 1, preL + 1 + (delimiterIndex - inL));
        root.right = myBuildTree(inorder, delimiterIndex + 1, inR, preorder, preL + 1 + (delimiterIndex - inL), preR);

        return root;
    }

}
