package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 二叉树的节点个数的范围是 [1,10^4]
 * 队列迭代
 */
public class _12_FindBottomLeftValue_2 {

    public int findBottomLeftValue(TreeNode root) {
        int maxDepth = 0;
        int leftDeepestVal = root.val;
        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            depth++;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    if (depth > maxDepth) {
                        maxDepth = depth;
                        leftDeepestVal = node.val;
                    }
                    continue;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return leftDeepestVal;
    }
}
