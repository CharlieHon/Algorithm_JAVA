package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/2 10:05
 * @Description: 买卖股票的最佳时机含手续费
 */
public class Solution714 {

    // 法1：dp
    public int maxProfit(int[] prices, int fee) {
        // dp[i][0] 不持有
        // dp[i][1] 持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i  = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    // 法2：贪心【比较难想】
    // 1. 收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票）
    // 2。 前一天是收获利润区间里的最后一天（相当于真正卖出），今天要重新记录下最小价格
    // 3. 不操作，保持原有状态（买入，卖出，不买不卖）
    public int maxProfit2(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 情况二：相当于买入
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // 情况三：保持原有状态（因为此时买则不便宜，卖则亏本）
            if (minPrice <= prices[i] && prices[i] <= minPrice + fee) {
                continue;
            }

            // 计算利润，可能有多次计算利润，最后一次计算利润才是真正意义的卖出
            if (minPrice + fee < prices[i]) {
                result += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee; // 情况一，这一步很关键，避免重复扣手续费
            }
        }
        return result;
    }
}
