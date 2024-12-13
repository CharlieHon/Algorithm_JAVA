package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/12 11:31
 * @Description: 斐波那契数列
 * F(0) = 0, F(1) = 1，求 F(n)
 */
public class Solution509 {
    public int fib(int n) {
        int a = 0, b = 1;
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }
        return a;
    }

    /**
     * dp[i] 第 i 个的值
     * dp[i] = dp[i - 1] + dp[i - 2];
     * dp[0] = 0, dp[1] = 1
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
