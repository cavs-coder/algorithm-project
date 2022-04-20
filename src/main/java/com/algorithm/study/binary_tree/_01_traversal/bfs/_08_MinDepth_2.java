package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * BFS
 */
public class _08_MinDepth_2 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int deep = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            deep++;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                //层序遍历，当前层下一层左右子节点都为空，第一次走进此判断条件时，则必定是第一个出现的最小深度
                if (node.left == null && node.right == null) {
                    return deep;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return deep;
    }
}
