package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 */
public class _14_SolveNQueens_2 {

    List<List<String>> result = new ArrayList<>();
    char[][] chessboard;

    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }

        backtracking(n, 0);
        return result;
    }

    private void backtracking(int n, int row) {
        if (row == n) {
            change(n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }

    private void change(int n) {
        List<String> path = new ArrayList<>();
        for (char[] chars : chessboard) {
            path.add(String.copyValueOf(chars));
        }

        result.add(path);
    }

    private boolean isValid(int n, int row, int col) {
        //1、不能同列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        //2、左上45°不能同斜线，保证之前发生的就能保证所有的
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        //3、右上135°不能同斜线，保证之前发生的就能保证所有的
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _14_SolveNQueens_2().solveNQueens(4));
    }
}
