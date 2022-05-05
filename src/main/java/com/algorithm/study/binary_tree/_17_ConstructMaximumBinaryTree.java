package com.algorithm.study.binary_tree;

/**
 * 654. 最大二叉树
 */
public class _17_ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return myConstructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode myConstructMaximumBinaryTree(int[] nums, int left, int right) {
        if (right - left == 0) {
            return null;
        }

        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int maxIndex = left;
        int maxVal = nums[left];
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = myConstructMaximumBinaryTree(nums, left, maxIndex);
        root.right = myConstructMaximumBinaryTree(nums, maxIndex + 1, right);

        return root;
    }
}
