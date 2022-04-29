package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 前序递归回溯
 */
public class _14_PathSum_1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> paths = new ArrayList<>();
        if (root == null) return result;
        pathSum(root, paths, targetSum);
        return result;
    }

    private void pathSum(TreeNode node, List<Integer> paths, int targetSum) {
        paths.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(paths));
            return;
        }
        if (node.left != null) {
            pathSum(node.left, paths, targetSum);
            paths.remove(paths.size() - 1);
        }
        if (node.right != null) {
            pathSum(node.right, paths, targetSum);
            paths.remove(paths.size() - 1);
        }
    }
}
