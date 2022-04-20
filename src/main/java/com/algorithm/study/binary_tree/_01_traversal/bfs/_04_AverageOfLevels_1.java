package com.algorithm.study.binary_tree._01_traversal.bfs;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * DFS递归
 */
public class _04_AverageOfLevels_1 {

    List<Double> sums = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        depthFirst(root, 0);
        return getResult();
    }

    private void depthFirst(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (deep < sums.size()) {
            sums.set(deep, sums.get(deep) + node.val);
            counts.set(deep, counts.get(deep) + 1);
        }
        if (deep == sums.size()) {
            sums.add(node.val * 1.0);
            counts.add(1);
        }
        deep++;
        depthFirst(node.left, deep);
        depthFirst(node.right, deep);
    }

    private List<Double> getResult() {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < sums.size(); i++) {
            result.add(sums.get(i) / counts.get(i));
        }
        return result;
    }
}
