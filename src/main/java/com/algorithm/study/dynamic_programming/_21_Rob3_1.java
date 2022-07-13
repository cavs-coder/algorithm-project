package com.algorithm.study.dynamic_programming;

import com.algorithm.study.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 记忆化递归
 *
 *  偷当前节点
 *  val1 = node.val + node.left.left.val + node.left.right.val
 *                  + node.right.left.val + node.right.right.val
 *  不偷当前节点
 *  val2 = node.left.val + node.right.val
 *
 *  记忆化递归，时间复杂度O(n)，空间复杂度O(n)，n为节点个数，平衡二叉树空间复杂度为O(logn), 最大n = 2^k-1 ，k为1开始的深度
 *          1
 *       1      3
 *    1     1
 *   1  1  2  2
 * 1  1      1
 */
public class _21_Rob3_1 {

    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        int max = Math.max(val1, val2);

        //记忆化递归，结构不变，当前节点的最大金额一定不变。
        map.put(root, max);

        return max;
    }
}
