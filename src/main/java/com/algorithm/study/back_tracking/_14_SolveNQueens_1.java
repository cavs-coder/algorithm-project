package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 */
public class _14_SolveNQueens_1 {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(".");
            }
            path.add(builder.toString());
        }

        backtracking(n, 0);
        return result;
    }

    private void backtracking(int n, int row) {
        if (row == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col)) {
                StringBuilder builder = new StringBuilder(path.get(row));
                String back = builder.toString();
                builder.replace(col, col + 1, "Q");
                path.set(row, builder.toString());
                backtracking(n, row + 1);
                path.set(row, back);
            }
        }
    }

    private boolean isValid(int n, int row, int col) {
        //1、不能同列
        for (int i = 0; i < row; i++) {
            if ("Q".equals(path.get(i).substring(col, col + 1))) {
                return false;
            }
        }

        //2、左上45°不能同斜线，保证之前发生的就能保证所有的
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(path.get(i).substring(j, j + 1))) {
                return false;
            }
        }

        //3、右上135°不能同斜线，保证之前发生的就能保证所有的
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(path.get(i).substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _14_SolveNQueens_1().solveNQueens(4));
    }
}
