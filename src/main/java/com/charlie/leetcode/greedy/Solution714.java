package com.charlie.leetcode.greedy;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/11 10:26
 * @Description: 买卖股票的最佳时机含手续费
 * 每次交易需要扣除手续费
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 情况1：当前价格更小，则更新最小值
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 情况2：如果当前价格扣完税不赚钱，则不进行任何操作。这一步可省略
            if (prices[i] <= minPrice + fee) {
                continue;
            }
            // 情况3：当前卖出赚钱
            if (minPrice + fee < prices[i]) {
                result += prices[i] - minPrice - fee;
                // ▲▲▲重点：在连续上升区间，只能在最后一个卖出(因为有手续费)
                // 通过更新最小值为 当前价格 - fee，可以保证在连续上升区间  ---不重复扣税---
                minPrice = prices[i] - fee;
            }
        }
        return result;
    }
}
