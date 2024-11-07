package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: charlie
 * @date: Created in 2024/11/7 10:33
 * N皇后：回溯法
 */
public class Solution51 {   // 使用2维数组模拟棋盘

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        return null;
    }

    /**
     * 回溯
     * @param n 棋盘大小
     * @param row 递归到第几行
     * @param chessboard 2维棋盘
     */
    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row + 1, chessboard);
                // 回溯
                chessboard[row][col] = '.';
            }
        }

    }

    // 将2维字符数组，转成字符串列表
    private List<String> array2List(char[][] array) {
        List<String> list = new ArrayList<>();
        for (char[] c : array) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    // 判断n皇后位置是否合法（不在同一列、不在同一对角线）
    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}

class Solution51Pro {
    private List<List<String>> res;

    // boolean数组中每个元素代表一条直（斜）线
    private boolean[] usedCol, usedDiag45, usedDiag135;

    public List<List<String>> solveQueens(int n) {

        usedCol = new boolean[n];               // 列方向直线条数有n
        usedDiag45 = new boolean[2 * n - 1];    // 45°方向斜线条数为 2 * n - 1
        usedDiag135 = new boolean[2 * n - 1];   // 135°方向斜线条数为 2 * n - 1

        // 用于收集结果，元素的index表示棋盘的row，元素的value代表棋盘的column
        int[] board = new int[n];

        backTracking(board, n, 0);

        return res;
    }

    private void backTracking(int[] board, int n, int row) {
        if (row == n) {
            // 收集结果
            List<String> temp = new ArrayList<>();
            for (int i : board) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';
                temp.add(String.valueOf(str));
            }
            res.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCol[col] || usedDiag45[row + col] || usedDiag135[row - col + n - 1]) {
                continue;
            }

            board[row] = col;
            usedCol[col] = true;
            usedDiag45[row + col] = true;
            usedDiag135[row - col + n - 1] = true;
            backTracking(board, n, row + 1);
            usedCol[col] = false;
            usedDiag45[row + col] = false;
            usedDiag135[row - col + n - 1] = false;
        }
    }

}