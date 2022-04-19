package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * BFS
 */
public class _04_AverageOfLevels_2 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double total = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                total += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(total / len);
        }

        return result;
    }
}
