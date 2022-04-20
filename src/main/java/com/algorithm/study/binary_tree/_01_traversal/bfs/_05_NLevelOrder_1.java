package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 * DFS递归
 */
public class _05_NLevelOrder_1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        depthFirst(root, 0);
        return result;
    }

    private void depthFirst(Node node, int deep) {
        if (node == null) {
            return;
        }
        if (deep == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(deep).add(node.val);
        deep++;
        List<Node> children = node.children;
        if (children == null || children.size() == 0) {
            return;
        }
        for (Node child : children) {
            depthFirst(child, deep);
        }
    }
}
