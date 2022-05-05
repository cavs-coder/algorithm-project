package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 530. 二叉搜索树的最小绝对差
 * 栈迭代
 */
public class _21_GetMinimumDifference_3 {

    public int getMinimumDifference(TreeNode root) {
        int minVal = Integer.MAX_VALUE;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                if (pre != null) {
                    minVal = Math.min(cur.val - pre.val, minVal);
                }
                pre = cur;

                cur = cur.right;
            }
        }
        return minVal;
    }

}
