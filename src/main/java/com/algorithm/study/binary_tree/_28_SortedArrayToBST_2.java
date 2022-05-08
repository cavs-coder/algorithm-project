package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 迭代(左闭右闭)
 * 1、获得数组中间元素做根节点
 * 2、如果左边还有值，处理左区间
 * 3、如果右边还有值，处理右区间
 */
public class _28_SortedArrayToBST_2 {

    public TreeNode sortedArrayToBST(int[] nums) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        TreeNode root = new TreeNode(-1);
        nodeQueue.offer(root);
        leftQueue.offer(0);
        rightQueue.offer(nums.length - 1);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer l = leftQueue.poll();
            Integer r = rightQueue.poll();

            //1、获得数组中间元素做根节点
            int mid = l + (r - l) / 2;
            node.val = nums[mid];

            //2、如果左边还有值，处理左区间
            if (l <= mid - 1) {
                node.left = new TreeNode(-1);
                nodeQueue.offer(node.left);
                leftQueue.offer(l);
                rightQueue.offer(mid - 1);
            }

            //3、如果右边还有值，处理右区间
            if (r >= mid + 1) {
                node.right = new TreeNode(-1);
                nodeQueue.offer(node.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(r);
            }
        }

        return root;
    }
}
