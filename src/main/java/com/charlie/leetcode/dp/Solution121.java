package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/30 11:06
 * @Description: 买卖股票的最佳时机
 */
public class Solution121 {

    // dp法
    public int maxProfit1(int[] prices) {
        // dp[i][0] 表示第i天**持有**股票时，手中现金
        // dp[i][1] 表示第i天**不持有**股票时，手中现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 第i天持有：   1) i-1天持有 2) i天买入
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 第i天不持有：  1) i-1天不持有 2) i天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }

    // 贪心法
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);           // 取最左最小价格
            result = Math.max(result, prices[i] - minPrice);    // 直接取最大区间利润
        }

        return result;
    }
}
