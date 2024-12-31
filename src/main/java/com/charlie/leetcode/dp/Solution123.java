package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/31 10:42
 * @Description: 买卖股票的最佳时机Ⅲ
 * 最多可以完成 **两笔** 交易
 */
public class Solution123 {

    public int maxProfit(int[] prices) {
        // 最多可以完成两笔交易，则每天可以有5中状态，0：不操作、1：第一次买入、2：第一次卖出、3：第二次买入、4“第二次卖出
        // dp[i][j] 第i天状态j时余额
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];  // 第一天买入
        dp[0][2] = 0;           // 第一天买入后卖出
        dp[0][3] = -prices[0];  // 在dp[0][2]的基础上再次买入
        dp[0][4] = 0;           // 在dp[0][3]的基础上再次卖出

        for (int i = 1; i < prices.length; i++) {
            // dp[i][0] = dp[i- 1][0];  // 无操作状态，可以省略
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
