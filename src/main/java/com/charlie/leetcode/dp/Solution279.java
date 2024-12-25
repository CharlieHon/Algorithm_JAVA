package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/25 14:20
 * @Description: 完全平方数
 */
public class Solution279 {

    public int numSquares(int n) {
        // dp[i] 表示容量为i的背包，放满时平方数最小数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        // 完全平方数 1, 4, 9, 16, 25, 36, 49, 64, 81, 100. 因为 n <= 10^4
        for (int i = 1; i <= 100; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

}
