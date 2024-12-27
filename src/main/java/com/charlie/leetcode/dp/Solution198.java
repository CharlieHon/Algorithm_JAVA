package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/27 11:30
 * @Description: 打家劫舍
 */
public class Solution198 {

    public int rob(int[] nums) {
        // dp[i] 表示到第i家时最大金额
        int[] dp = new int[nums.length + 2];

        for (int i = 0; i < nums.length; i++) {
            // max(前一家偷了, 前一家没偷);
            // dp[i] = max(dp[i - 1], dp[i - 2] + 当前家价值)
            dp[i+2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }

        return dp[nums.length + 1];
    }

}
