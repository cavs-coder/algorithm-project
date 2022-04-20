package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * DFS递归
 */
public class _02_N_Preorder_1 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        depthFirst(root);
        return result;
    }

    public void depthFirst(Node node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        List<Node> children = node.children;
        if (children == null || children.size() == 0) {
            return;
        }
        for (Node child : children) {
            depthFirst(child);
        }
    }
}
