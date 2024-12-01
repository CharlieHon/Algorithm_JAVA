package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/12/1 10:23
 * @description: 买卖股票的最佳时机Ⅱ
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

}
