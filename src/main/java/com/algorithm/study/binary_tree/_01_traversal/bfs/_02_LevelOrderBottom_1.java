package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 * 从顶向下然后反转列表元素
 * DFS递归
 */
public class _02_LevelOrderBottom_1 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        depthFirst(root, 0);
        Collections.reverse(result);
        return result;
    }

    private void depthFirst(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (deep == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(deep).add(node.val);
        depthFirst(node.left, deep + 1);
        depthFirst(node.right, deep + 1);
    }
}
