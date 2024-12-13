package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/13 12:19
 * @Description: 使用最小花费爬楼梯
 */
public class Solution746 {
    /**
     * dp[i] 表示达到台阶 i 所需要花费的体力
     * @param cost cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; dp[1] = 0;
        // dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
