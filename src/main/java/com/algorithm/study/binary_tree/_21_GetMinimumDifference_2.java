package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 中序遍历过程中就计算出值
 */
public class _21_GetMinimumDifference_2 {

    int minVal = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return minVal;
    }

    public void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);

        if (pre != null) {
            minVal = Math.min(node.val - pre.val, minVal);
        }
        pre = node;

        traversal(node.right);
    }
}
