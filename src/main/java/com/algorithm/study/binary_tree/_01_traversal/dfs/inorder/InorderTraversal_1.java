package com.algorithm.study.binary_tree._01_traversal.dfs.inorder;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *     递归法
 */
public class InorderTraversal_1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
