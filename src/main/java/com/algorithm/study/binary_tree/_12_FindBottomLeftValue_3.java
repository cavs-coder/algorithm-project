package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 二叉树的节点个数的范围是 [1,10^4]
 * 队列迭代
 */
public class _12_FindBottomLeftValue_3 {

    public int findBottomLeftValue(TreeNode root) {
        int leftDeepestVal = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    leftDeepestVal = node.val;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return leftDeepestVal;
    }
}
