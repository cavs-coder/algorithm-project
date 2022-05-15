package com.algorithm.study.back_tracking;

/**
 * 37. 解数独
 * 回溯+二维递归: 判断每一个格子
 */
public class _15_SolveSudoku_1 {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                //不需要填充的跳过
                if (board[row][col] != '.') {
                    continue;
                }
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(row, col, val, board)) {
                        board[row][col] = val;
                        //先行后列找到第一个需要填充值的空格，进行二维递归
                        if (backtracking(board)) {
                            return true;
                        }
                        //这条路走不通，需要回溯
                        board[row][col] = '.';
                    }
                }

                //如果9个值都不满足要求，说明这条路走不通
                return false;
            }
        }

        //只有一种情况能走到这，就是9*9的二维递归都填满了且满足条件，即解出了数独
        return true;
    }

    private boolean isValid(int row, int col, int val, char[][] board) {
        //1、同行不重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        //2、同列不重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }

        //3、所处九宫格不重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
