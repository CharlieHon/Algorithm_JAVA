package com.charlie.leetcode;

/**
 * 螺旋矩阵Ⅱ
 */
public class Solution59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int loop = 1;
        int i, j;   // i代表行，j代表列
        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时，j不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                result[startX][j] = count++;
            }

            // 右列
            for (i = startX; i < n - offset; i++) {
                result[i][j] = count++;
            }

            // 底部
            for (; j > startY; j--) {
                result[i][j] = count++;
            }

            // 左列
            for (; i > startX; i--) {
                result[i][j] = count++;
            }

            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            result[startX][startY] = count;
        }
        return result;
    }

}
