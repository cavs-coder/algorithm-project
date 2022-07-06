package com.algorithm.study.dynamic_programming;

/**
 * 509. 斐波那契数
 * 暴力法：时间复杂度O(n)、空间复杂度O(1)
 */
public class _1_Fib_1 {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = a + b;
            a = b;
            b = fn;
        }
        return fn;
    }
}
