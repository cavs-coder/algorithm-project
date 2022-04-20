package com.algorithm.study.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 * DFS迭代
 */
public class _02_N_Preorder_2 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node != null) {
                stack.pop();
                List<Node> children = node.children;
                if (children != null && children.size() > 0) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }

                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                Node pop = stack.pop();
                result.add(pop.val);
            }
        }

        return result;
    }
}
