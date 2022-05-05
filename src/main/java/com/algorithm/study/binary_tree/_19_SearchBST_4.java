package com.algorithm.study.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 700. 二叉搜索树中的搜索
 * 层序迭代，利用二叉搜索树左至右升序特点
 */
public class _19_SearchBST_4 {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }
}
