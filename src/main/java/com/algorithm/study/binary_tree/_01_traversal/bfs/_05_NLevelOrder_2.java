package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * BFS
 */
public class _05_NLevelOrder_2 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                level.add(node.val);
                List<Node> children = node.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    queue.offer(child);
                }
            }
            result.add(level);
        }

        return result;
    }
}
