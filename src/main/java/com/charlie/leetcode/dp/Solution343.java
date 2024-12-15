package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/15 14:26
 * @Description: 整数拆分：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化
 */
public class Solution343 {

    public int integerBreaking(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;  // 2 = 1 + 1, 1 * 1 = 1

        // dp[i] 即 正整数i的最大乘积
        // dp[i] 可以拆分成
        //      j * (i - j) 即两个数相乘
        //      j * dp[i - j] 即 两个以上数相乘
        //      并与 dp[i] 取最大值
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n - 1];
    }

}
