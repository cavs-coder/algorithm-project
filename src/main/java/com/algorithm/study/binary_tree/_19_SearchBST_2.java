package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 700. 二叉搜索树中的搜索
 * 层序迭代
 */
public class _19_SearchBST_2 {

    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return null;
    }
}
