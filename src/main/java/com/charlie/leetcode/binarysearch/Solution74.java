package com.charlie.leetcode.binarysearch;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/9 13:11
 * @Description: 搜索二维矩阵
 */
class Solution74 {

    // 排除法：将 target 与矩阵右上角进行比较
    // 时间复杂度 O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    // 二叉查找，将查找的下标转换为矩阵中的坐标
    // 时间复杂度 O(log(m * n))
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || matrix[m - 1][n - 1] < target) {
            return false;
        }

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }
}
