package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 队列迭代-层序
 */
public class _05_IsSameTree_3 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            TreeNode qNode = queue.poll();

            if (pNode == null && qNode == null) {
                continue;
            }

            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }

            queue.offer(pNode.left);
            queue.offer(qNode.left);
            queue.offer(pNode.right);
            queue.offer(qNode.right);
        }

        return true;
    }
}
