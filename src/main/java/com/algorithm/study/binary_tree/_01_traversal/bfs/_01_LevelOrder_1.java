package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 深度优先遍历---递归法
 */
public class _01_LevelOrder_1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        depthFirst(root, 0);
        return result;
    }

    public void depthFirst(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;

        if (result.size() < deep) {
            result.add(new ArrayList<>());
        }

        result.get(deep - 1).add(node.val);
        depthFirst(node.left, deep);
        depthFirst(node.right, deep);
    }
}
