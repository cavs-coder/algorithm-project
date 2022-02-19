package com.algorithm.study.array._4_simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵 medium
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

        System.out.println(new SpiralOrder().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int total = n * matrix[0].length;
        //top/bottom/left/right
        int t = 0;
        int b = n - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while (res.size() < total) {
            for (int i = l; i <= r && res.size() < total; i++) res.add(matrix[t][i]);
            t++;
            for (int i = t; i <= b && res.size() < total; i++) res.add(matrix[i][r]);
            r--;
            for (int i = r; i >= l && res.size() < total; i--) res.add(matrix[b][i]);
            b--;
            for (int i = b; i >= t && res.size() < total; i--) res.add(matrix[i][l]);
            l++;
        }

        return res;
    }
}
