package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 112. 路径总和
 */
public class _13_HasPathSum_2 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val);

        while (!stack.isEmpty()) {
            int val = (int) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if (node.left == null && node.right == null && targetSum == val) return true;
            if (node.right != null) {
                stack.push(node.right);
                stack.push(val + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(val + node.left.val);
            }
        }

        return false;
    }
}
