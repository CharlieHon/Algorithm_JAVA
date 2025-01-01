package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/1 17:06
 * @Description: 买卖股票的最佳时机Ⅳ
 * 最多可以完成 k 笔交易
 */
public class Solution188 {
    // 最大进行k次交易，必须在再次购买前出售之前的股票
    // 每次交易分买和卖，则可以有2*k+1(无操作)种状态
    public int maxProfit(int[] prices, int k) {
        // dp[i][j]表示第i天状态j下的最大余额
        int[][] dp = new int[prices.length][2 * k + 1];
        // 初始化：奇数天卖出，偶数天买入
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if ((j & 1) == 1) { // 奇数买入
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {    // 偶数卖出
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        // 最后一次卖出，一定是利润最大的
        return dp[prices.length - 1][2 * k];
    }
}
