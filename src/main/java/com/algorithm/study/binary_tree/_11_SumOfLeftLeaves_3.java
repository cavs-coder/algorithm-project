package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 404. 左叶子之和
 * 前序栈迭代
 */
public class _11_SumOfLeftLeaves_3 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return sum;
    }
}
