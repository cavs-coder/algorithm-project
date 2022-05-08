package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 538. 把二叉搜索树转换为累加树
 * 迭代，反中序遍历，后中左
 */
public class _29_ConvertBST_2 {

    int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int preSum = 0;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur != null) {
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                stack.push(cur);
                stack.push(null);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                cur = stack.pop();
                preSum += cur.val;
                cur.val = preSum;
            }
        }

        return root;
    }
}
