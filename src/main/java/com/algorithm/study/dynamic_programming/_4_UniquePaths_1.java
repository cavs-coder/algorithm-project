package com.algorithm.study.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * 62. 不同路径
 * 二叉树法一：机器人每次只能向下走或者向右走，所以机器人走过的不同路径可以看成是一颗二叉树。
 *            向下的节点为左子树，向右的节点为右子树，所以求二叉树头结点(1,1)到其中一个叶子结点(m,n)的路径，
 *            可以转化为求二叉树的所有叶子结点。
 *            当前节点的叶子节点个数为左子树加右子树的叶子节点：traversal(i + 1, j, m, n) + traversal(i, j + 1, m, n)。
 * 时间复杂度：深度从1开始算，深度为 m+n-1，假设遍历一颗满二叉树(不是满二叉树，近似)，即为O(2^(m+n-1))，指数级别的时间复杂度，非常大。
 *            所以需要缓存来优化，走过的某一个节点，它虽然在二叉树的不同位置，但是结构是一样的，到叶子节点(m,n)的路径数目是唯一的。
 *            将次节点存储起来，再次走走过此节点直接返回路径数目即可。时间复杂度优化为O(m*n)
 * 空间复杂度为额外的缓存空间O(m*n)
 *
 * 二叉树法二：
 *            其实时间复杂度还可以优化，碰到下边界或右边界直接返回1，比如碰到下边界，再继续递归也只是一直往右节点递归，
 *            直到找到叶子节点，整条路径都无分叉。并且还省去下边界的节点一系列无效的左子树递归，即traversal2方法。
 *            这是常量级别的优化，时间，空间复杂度为O(m*n - (m-1+n-1)*2)
 */
public class _4_UniquePaths_1 {

    public static void main(String[] args) {
        new _4_UniquePaths_1().uniquePaths(2, 3);
    }

    static int count = 0;
    Map<String, Integer> pathCountMap = new HashMap<>();

    public int uniquePaths(int m, int n) {
        int traversal = traversal(1, 1, m, n);
        // System.out.println("i: " + traversal + ", count: " + count);
        return traversal;
    }

    private int traversal(int i, int j, int m, int n) {
        // count++;
        String key = i + "," + j;
        if (pathCountMap.containsKey(key)) {
            return pathCountMap.get(key);
        }
        if (i > m || j > n) return 0;
        if (i == m && j == n) return 1;

        pathCountMap.put(key, traversal(i + 1, j, m, n) + traversal(i, j + 1, m, n));
        return pathCountMap.get(key);
    }

    private int traversal2(int i, int j, int m, int n) {
        // count++;
        String key = i + "," + j;
        if (pathCountMap.containsKey(key)) {
            return pathCountMap.get(key);
        }

        if (i == m || j == n) return 1;

        pathCountMap.put(key, traversal(i + 1, j, m, n) + traversal(i, j + 1, m, n));
        return pathCountMap.get(key);
    }
}
