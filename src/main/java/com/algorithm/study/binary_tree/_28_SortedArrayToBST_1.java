package com.algorithm.study.binary_tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 递归(左闭右闭)
 * 1、获得数组中间元素做根节点
 * 2、如果左边还有值，处理左区间
 * 3、如果右边还有值，处理右区间
 */
public class _28_SortedArrayToBST_1 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    public TreeNode traversal(int[] nums, int l, int r) {
        if (l > r) return null;
        //获得数组中间元素做根节点
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        //如果左边还有值，处理左区间
        if (l <= mid - 1) {
            node.left = traversal(nums, l, mid - 1);
        }
        //如果右边还有值，处理右区间
        if (r >= mid + 1) {
            node.right = traversal(nums, mid + 1, r);
        }

        return node;
    }
}
