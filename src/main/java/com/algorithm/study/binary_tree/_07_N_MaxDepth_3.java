package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. N 叉树的最大深度
 * bfs队列迭代
 */
public class _07_N_MaxDepth_3 {

    public int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            maxDepth++;
            while (len-- > 0) {
                Node node = queue.poll();
                List<Node> children = node.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    queue.offer(child);
                }
            }
        }

        return maxDepth;
    }
}
