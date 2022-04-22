package com.algorithm.study.binary_tree;

import java.util.Stack;

/**
 * 100. 相同的树
 * 栈迭代-前序
 */
public class _05_IsSameTree_2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() || !qStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();

            if (pNode == null && qNode == null) {
                continue;
            }

            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }

            pStack.push(pNode.right);
            pStack.push(pNode.left);
            qStack.push(qNode.right);
            qStack.push(qNode.left);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(new _05_IsSameTree_2().isSameTree(p, q));
    }
}
