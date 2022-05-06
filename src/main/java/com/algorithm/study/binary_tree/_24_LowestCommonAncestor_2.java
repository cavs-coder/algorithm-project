package com.algorithm.study.binary_tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 二叉搜索树的迭代法
 * 利用BST特性，第一次到达[p.val, q.val]或者[q.val, p.val]范围之间时，
 * 就是最近公共祖先，可以直接返回
 */
public class _24_LowestCommonAncestor_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        //题目只会存在一种区间情况，即p和q值大小已确定，[p.val, q.val]或者[q.val, p.val]
        //此时直接返回
        return root;
    }
}
