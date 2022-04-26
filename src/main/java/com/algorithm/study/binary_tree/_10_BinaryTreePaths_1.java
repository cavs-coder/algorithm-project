package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 递归
 */
public class _10_BinaryTreePaths_1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> result) {
        paths.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                builder.append(paths.get(i)).append("->");
            }
            builder.append(paths.get(paths.size() - 1));
            result.add(builder.toString());
        }

        if (node.left != null) {
            traversal(node.left, paths, result);
            paths.remove(paths.size() - 1);
        }
        if (node.right != null) {
            traversal(node.right, paths, result);
            paths.remove(paths.size() - 1);
        }
    }
}
