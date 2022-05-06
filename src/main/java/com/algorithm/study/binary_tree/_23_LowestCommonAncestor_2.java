package com.algorithm.study.binary_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 * 1、dfs遍历，哈希表存储每个节点的父节点
 * 2、p往根节点回溯，记录路径
 * 3、q往根节点回溯时判断该点是否已在路径中存在
 */
public class _23_LowestCommonAncestor_2 {

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }

        return null;
    }

    public void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs(node.left);
        }

        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }
}
