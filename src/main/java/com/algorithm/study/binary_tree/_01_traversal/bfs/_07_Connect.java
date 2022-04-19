package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 117. 填充每个节点的下一个右侧节点指针 II
 * BFS
 */
public class _07_Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return root;
    }
}
