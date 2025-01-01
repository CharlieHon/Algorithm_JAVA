package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/1 17:10
 * @Description: 最佳买卖股票时机含冷冻期
 */
public class Solution309 {

    // public int maxProfit(int[] prices) {
    //     int[][] dp = new int[prices.length][2];
    //     // 两种状态：不持有股票和持有股票
    //     dp[0][0] = 0;               // 不持有状态
    //     dp[0][1] = -prices[0];      // 持有状态
    //     for (int i = 1; i < prices.length; i++) {
    //         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    //         // i天不持有，当天是冷冻期/不是
    //         // 冷冻期：dp[i][0] = dp[i - 2][1] + prices[i- 1]
    //         // 非：   dp[i][0] = dp[i - 1][0] = dp[i - 2][0]
    //         dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    //     }
    //     return dp[prices.length - 1][0];
    // }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0;           // 0表示无操作
        dp[0][1] = -prices[0];  // 1表示买入
        dp[0][2] = 0;           // 2表示卖出
        dp[0][3] = 0;           // 3表示冷冻期

        for (int i = 1; i < prices.length; i++) {
            // 买入状态：1. 前一天即处于买入状态；2. 前一天无操作，今天买入；3.前一天冷冻，今天买入
            dp[i][1] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][0] - prices[i], dp[i - 1][3] - prices[i]));
            // 卖出状态：1. 前一天即处于卖出状态；2. 前一天处于买入状态，今天卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 冷冻期：前一天处于卖出状态
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]);
    }
}
