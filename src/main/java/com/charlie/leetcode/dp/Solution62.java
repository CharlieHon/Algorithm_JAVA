package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/14 12:42
 * @Description: 不同路径
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // 第 1 行都是1
        Arrays.fill(dp, 1);

        // 使用一维数组
        // i 表示后续的每行
        // j 表示每列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
