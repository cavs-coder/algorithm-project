package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 226. 翻转二叉树
 * DFS迭代(迭代中序也行，因为用栈存储，而不是指针引用)
 */
public class _01_InvertTree_2 {

    //后序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop();
                TreeNode pop = stack.pop();
                swapChildren(pop);
            }
        }

        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
