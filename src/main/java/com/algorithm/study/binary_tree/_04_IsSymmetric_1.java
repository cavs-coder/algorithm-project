package com.algorithm.study.binary_tree;

/**
 * 101. 对称二叉树
 * 递归
 */
public class _04_IsSymmetric_1 {

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        //能走下来的说明 left.val == right.val
        //比较 左子树:左、右子树：右 && 左子树:右、右子树：左
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
