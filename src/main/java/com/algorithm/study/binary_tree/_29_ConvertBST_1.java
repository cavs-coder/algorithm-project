package com.algorithm.study.binary_tree;

/**
 * 538. 把二叉搜索树转换为累加树
 * 递归，反中序遍历，后中左
 */
public class _29_ConvertBST_1 {

    int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);

        preSum += root.val;
        root.val = preSum;

        convertBST(root.left);

        return root;
    }
}
