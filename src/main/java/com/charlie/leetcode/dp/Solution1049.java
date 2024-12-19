package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/19 10:34
 * @Description: 最后一块石头重量
 */
public class Solution1049 {
    public int lastStoneWeight2(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 🔺：尽可能将石头分成重量相等的两堆
        int target = sum / 2;
        int[] dp = new int[target + 1];

        // 剩下的就是01背包问题
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; stones[i] <= j; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        // 最后分成 sum - dp[target] 和 dp[target] 两堆，取差即最后一块石头重量
        return sum - 2 * dp[target];
    }
}
