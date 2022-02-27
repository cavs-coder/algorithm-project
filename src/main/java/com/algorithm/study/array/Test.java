package com.algorithm.study.array;

import com.algorithm.study.array._2_double_pointer.SortedSquares;

import java.util.*;

public class Test {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0;
        int b = m - 1;
        int l = 0;
        int r = n - 1;
        int total = m*n;
        while(ans.size() < m*n){
            for(int i = l; i <= r && ans.size() < total; i++) ans.add(matrix[t][i]);
            t++;
            for(int i = t; i <= b && ans.size() < total; i++) ans.add(matrix[i][r]);
            r--;
            for(int i = r; i >= l && ans.size() < total; i--) ans.add(matrix[b][i]);
            b--;
            for(int i = b; i >= t && ans.size() < total; i--) ans.add(matrix[i][l]);
            l++;
        }
        return ans;
    }
}
