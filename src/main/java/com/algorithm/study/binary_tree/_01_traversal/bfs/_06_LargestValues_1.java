package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * DFS
 */
public class _06_LargestValues_1 {

    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        depthFirst(root, 0);
        return result;
    }

    private void depthFirst(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (deep < result.size()) {
            if (node.val > result.get(deep)) {
                result.set(deep, node.val);
            }
        }
        if (deep == result.size()) {
            result.add(node.val);
        }

        depthFirst(node.left, deep + 1);
        depthFirst(node.right, deep + 1);
    }
}
