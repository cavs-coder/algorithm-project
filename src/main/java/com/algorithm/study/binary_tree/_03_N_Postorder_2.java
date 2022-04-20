package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N 叉树的后序遍历
 * DFS递归
 */
public class _03_N_Postorder_2 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node != null) {
                stack.push(null);
                List<Node> children = node.children;
                if (children != null && children.size() > 0) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }
            } else {
                stack.pop();
                Node pop = stack.pop();
                result.add(pop.val);
            }
        }

        return result;
    }
}
