package com.algorithm.study.binary_tree;

/**
 * 572. 另一棵树的子树
 * 递归
 */
public class _06_IsSubtree_1 {

    public boolean isSubtree(TreeNode node, TreeNode subNode) {
        if (node == null) {
            return false;
        }

        //有一个匹配上就返回true
        return isSameTree(node, subNode) || isSubtree(node.left, subNode) || isSubtree(node.right, subNode);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
