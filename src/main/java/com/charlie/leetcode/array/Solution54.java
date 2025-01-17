package com.charlie.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/17 16:25
 * @Description: 螺旋矩阵
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        int cnt = 0, target = m * n;
        while (cnt < target) {
            // 每次添加元素时都根据元素个数判断一下，因为一行也能组成长方形
            for (int i = left; i <= right && cnt < target; i++) {
                res.add(matrix[top][i]);
                cnt++;
            }
            top++;

            for (int i = top; i <= bottom && cnt < target; i++) {
                res.add(matrix[i][right]);
                cnt++;
            }
            right--;

            for (int i = right; left <= i && cnt < target; i--) {
                res.add(matrix[bottom][i]);
                cnt++;
            }
            bottom--;

            for (int i = bottom; top <= i && cnt < target; i--) {
                res.add(matrix[i][left]);
                cnt++;
            }
            left++;
        }
        return res;
    }
}
