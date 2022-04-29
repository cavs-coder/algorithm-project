package com.algorithm.study.binary_tree;

/**
 * 513. 找树左下角的值
 * 二叉树的节点个数的范围是 [1,10^4]
 * 前序递归
 */
public class _12_FindBottomLeftValue_1 {

    int maxDepth = 0;
    int leftDeepestVal;

    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 1);
        return leftDeepestVal;
    }

    private void traversal(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                leftDeepestVal = node.val;
            }
            return;
        }
        if (node.left != null) traversal(node.left, depth + 1);
        if (node.right != null) traversal(node.right, depth + 1);
    }
}
