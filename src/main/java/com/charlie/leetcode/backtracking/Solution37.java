package com.charlie.leetcode.backtracking;

/**
 * @author: charlie
 * @date: Created in 2024/11/11 9:17
 * @description: 解9x9数独
 */
public class Solution37 {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    /**
     * 数独递归解：不需要终止条件，因为解数读要遍历整个树形结构寻找可能的叶子节点就立刻返回
     *
     */
    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;   // (i, j) 已有值
                }
                // (i, j)位置无值，遍历 '1'~'9' 尝试存放
                for (char k = '1'; k <= '9'; k++) {
                    // (i, j) 位置放 k 是否合法
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 在 (i, j) 位置 '1'~'9' 均不能放，所以不存在该数独的解
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了数独的解
        return true;
    }

    // 在 (row, col) 是否可以放入 val
    private boolean isValid(int row, int col, int val, char[][] board) {
        // 同一行是否有重复，数独大小是9x9所以行列均从0~9遍历
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        // 同一列是否有重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }

        // 同一个 3x3 内是否有重复
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
