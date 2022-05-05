package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * 队列迭代
 */
public class _18_MergeTrees_2 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }

            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }

            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }

            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }

            //8种情况 node1与node2的left或者right同时为null不用考虑、
            //node1不为null，node2为null也不用考虑，因为null与node1子节点合并时，node1子节点不变
        }

        return root1;
    }
}
