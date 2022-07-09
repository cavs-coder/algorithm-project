package com.algorithm.study.dynamic_programming;

/**
 * 343. 整数拆分
 *  递归，自顶向下，使用缓存避免重复计算。时间复杂度O(n^2)，空间复杂度O(n)
 *      自顶向下的递归树，便于理解
 *                                                                      5
 *                                   1, 4                              2, 3                3, 2         4, 1
 *                   1, 1 3       1, 2 2       1, 3 1            2, 1 2   2, 2 1          3, 1 1
 *       1,1, 1 2    1,1, 2 1     1,2, 1 1                       2,1, 1 1
 *       1,1,1, 1 1
 */
public class _6_IntegerBreak_1 {

    int[] res;

    public int integerBreak(int n) {
        res = new int[n + 1];
        return traversal(n);
    }

    public int traversal(int n) {
        if (n == 2) return 1;
        if (res[n] != 0) return res[n];
        int max = -1;
        for (int j = 1; j < n; j++) {
            max = Math.max(max, Math.max(j * (n - j), j * traversal(n - j)));
        }
        res[n] = max;
        return max;
    }
}
