package com.algorithm.study.binary_tree;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * 普通二叉树解法
 */
public class _22_FindMode_1 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        traversal(root);
        int maxVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxVal = Math.max(maxVal, entry.getValue());
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxVal == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        traversal(node.right);
    }
}
