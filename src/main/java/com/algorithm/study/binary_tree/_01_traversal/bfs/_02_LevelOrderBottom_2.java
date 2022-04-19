package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 * BFS
 * 从顶向下然后反转列表元素
 */
public class _02_LevelOrderBottom_2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }

        //反转列表
        Collections.reverse(result);

        return result;
    }
}
