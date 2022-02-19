package com.algorithm.study.array._4_simulation;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II medium
 *  // TODO: 2022/02/19 14:47 模拟法
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int n = 3;
        int[][] a = new GenerateMatrix().generateMatrix(n);

        for (int i = 0; i < a.length; i++) {
            int[] b = a[i];
            System.out.println(Arrays.toString(b));
        }
    }

    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        // top/bottom/left/right
        int t = 0;
        int b = n - 1;
        int l = 0;
        int r = n - 1;

        //count
        int c = 0;

        while (c < n * n) {
            for (int i = l; i <= r; i++) ans[t][i] = ++c;
            t++;
            for (int i = t; i <= b; i++) ans[i][r] = ++c;
            r--;
            for (int i = r; i >= l; i--) ans[b][i] = ++c;
            b--;
            for (int i = b; i >= t; i--) ans[i][l] = ++c;
            l++;
        }

        return ans;
    }
}
