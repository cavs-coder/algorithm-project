package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 501. 二叉搜索树中的众数
 * 栈迭代-利用二叉搜索树特性解法(中序遍历时处理)
 */
public class _22_FindMode_3 {

    public int[] findMode(TreeNode root) {

        //最少有一个
        int maxCount = 1;
        int count = 0;
        TreeNode pre = null;
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                if (pre == null || pre.val != cur.val) {
                    count = 1;
                } else {
                    count++;
                }

                if (maxCount == count) {
                    result.add(cur.val);
                } else if (maxCount < count) {
                    result.clear();
                    result.add(cur.val);
                    maxCount = count;
                }
                pre = cur;

                cur = cur.right;
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
