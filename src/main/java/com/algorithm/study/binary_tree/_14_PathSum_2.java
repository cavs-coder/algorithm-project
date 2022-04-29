package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 前序递归回溯
 */
public class _14_PathSum_2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> paths = new LinkedList<>();
        pathSum(root, paths, targetSum);
        return result;
    }

    private void pathSum(TreeNode node, LinkedList<Integer> paths, int targetSum) {
        if (node == null) return;

        paths.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(paths));
        }
        pathSum(node.left, paths, targetSum);
        pathSum(node.right, paths, targetSum);
        paths.removeLast();
    }
}
