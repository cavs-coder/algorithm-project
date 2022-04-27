package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 404. 左叶子之和
 * 队列层序迭代
 */
public class _11_SumOfLeftLeaves_4 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
}
