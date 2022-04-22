package com.algorithm.study.binary_tree;

/**
 * 100. 相同的树
 * 递归-前序
 */
public class _05_IsSameTree_1 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        else if (p != null && q == null) return false;
        else if (p == null && q == null) return true;
        else if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
