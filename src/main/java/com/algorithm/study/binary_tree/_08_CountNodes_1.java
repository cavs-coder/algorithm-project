package com.algorithm.study.binary_tree;

/**
 * 222. 完全二叉树的节点个数
 */
public class _08_CountNodes_1 {

    Integer count = 0;
    public int countNodes(TreeNode root) {
        depthFirst(root);
        return count;
    }

    private void depthFirst(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        depthFirst(root.left);
        depthFirst(root.right);
    }
}
