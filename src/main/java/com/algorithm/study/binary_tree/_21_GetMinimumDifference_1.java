package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 中序遍历得到有序数组后求最小差值
 */
public class _21_GetMinimumDifference_1 {

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            minVal = Math.min(list.get(i + 1) - list.get(i), minVal);
        }

        return minVal;
    }

    public void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);
        list.add(node.val);
        traversal(node.right);
    }
}
