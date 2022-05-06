package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 递归-利用二叉搜索树特性解法(中序遍历时处理)
 */
public class _22_FindMode_2 {

    //最少有一个
    int maxCount = 1;
    int count = 0;
    TreeNode pre = null;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);

        //计数
        if (pre == null || pre.val != node.val) {
            count = 1;
        } else {
            count++;
        }

        //存储
        if (maxCount == count) {
            result.add(node.val);
        } else if (maxCount < count) {
            result.clear();
            result.add(node.val);
            maxCount = count;
        }
        pre = node;

        traversal(node.right);
    }
}
