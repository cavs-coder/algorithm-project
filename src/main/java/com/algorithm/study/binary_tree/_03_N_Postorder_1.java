package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * DFS递归
 */
public class _03_N_Postorder_1 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        depthFirst(root);
        return result;
    }

    private void depthFirst(Node node) {
        if (node == null) {
            return;
        }

        List<Node> children = node.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                depthFirst(child);
            }
        }

        result.add(node.val);
    }
}
