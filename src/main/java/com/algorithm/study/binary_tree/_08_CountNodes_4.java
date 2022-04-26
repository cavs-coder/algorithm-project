package com.algorithm.study.binary_tree;

/**
 * 222. 完全二叉树的节点个数
 */
public class _08_CountNodes_4 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            //左子树必读为满二叉树
            //左子树节点 + 根节点：(2^leftDepth - 1) + 1 == 2^leftDepth == 1<<leftDepth
            // + 右子树节点 countNodes(root.right)
            return (1 << leftDepth) + countNodes(root.right);
        }
        //不相等，说明右子树为满二叉树
        return (1 << rightDepth) + countNodes(root.left);
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
}
