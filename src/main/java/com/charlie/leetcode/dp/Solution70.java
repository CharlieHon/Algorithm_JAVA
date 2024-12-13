package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/13 12:10
 * @Description: 爬楼梯
 */
public class Solution70 {

    /**
     * dp[i]
     * dp[i] = dp[i - 1] + dp[i - 2]
     * dp[1] = 1
     * dp[2] = 2
     */
    public int climStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1; dp[2] = 2;
        int sum;
        for (int i = 3; i <= n; i++) {
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
