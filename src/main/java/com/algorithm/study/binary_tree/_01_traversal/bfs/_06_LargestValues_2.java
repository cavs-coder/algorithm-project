package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * BFS
 */
public class _06_LargestValues_2 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }

        return result;
    }
}
