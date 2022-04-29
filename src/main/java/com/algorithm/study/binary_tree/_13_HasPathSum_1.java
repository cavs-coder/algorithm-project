package com.algorithm.study.binary_tree;

/**
 * 112. 路径总和
 */
public class _13_HasPathSum_1 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
