package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * DFS
 */
public class _03_RightSideView_1 {

    public List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        depthFirst(root, 0);
        return result;
    }

    public void depthFirst(TreeNode node, int deep) {
        if (node == null) {
            return;
        }

        if (result.size() == deep) {
            result.add(node.val);
        }

        deep++;
        depthFirst(node.right, deep);
        depthFirst(node.left, deep);
    }
}
