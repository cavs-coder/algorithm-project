package com.algorithm.study.binary_tree;

/**
 * 404. 左叶子之和
 */
public class _11_SumOfLeftLeaves_1 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        return getLeftNode(root, "", sum);
    }

    private int getLeftNode(TreeNode node, String direction, int sum) {
        if (node == null) {
            return sum;
        }
        if (node.left == null && node.right == null && direction.equals("left")) {
            sum += node.val;
            return sum;
        }
        int a = getLeftNode(node.left, "left", sum);
        int b = getLeftNode(node.right, "right", sum);
        return a + b;
    }


}
