package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 递归
 */
public class _10_BinaryTreePaths_2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        traversal(root, "", result);
        return result;
    }

    private void traversal(TreeNode node, String path, List<String> result) {
        path += node.val;
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        if (node.left != null) traversal(node.left, path + "->", result);
        if (node.right != null) traversal(node.right, path + "->", result);
    }
}
