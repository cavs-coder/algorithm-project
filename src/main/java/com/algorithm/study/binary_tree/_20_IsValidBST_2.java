package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 栈迭代
 */
public class _20_IsValidBST_2 {

    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                if (pre >= cur.val) {
                    return false;
                }
                pre = cur.val;

                cur = cur.right;
            }
        }

        return true;
    }
}
