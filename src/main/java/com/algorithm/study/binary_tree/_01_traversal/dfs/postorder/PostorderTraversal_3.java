package com.algorithm.study.binary_tree._01_traversal.dfs.postorder;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 统一迭代法（前中后序遍历）
 */
public class PostorderTraversal_3 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
//                stack.pop();
//                stack.push(node);
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                TreeNode pop = stack.pop();
                result.add(pop.val);
            }
        }

        return result;
    }
}
