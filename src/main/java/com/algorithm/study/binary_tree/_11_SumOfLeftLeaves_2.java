package com.algorithm.study.binary_tree;

/**
 * 404. 左叶子之和
 * 前序递归
 */
public class _11_SumOfLeftLeaves_2 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int midVal = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midVal += root.left.val;
        }

        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal = sumOfLeftLeaves(root.right);

        return midVal + leftVal + rightVal;
    }
}
