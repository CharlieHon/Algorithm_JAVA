package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/25 11:42
 * @Description: 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 **最少的硬币个数** 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑够金额i所需硬币最小数量
        int[] dp = new int[amount + 1];
        // 初始化：考虑到地推公式的特性，dp[j]必须初始化为一个最大的数，，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 只有dp[j-coins[i]]不是初始最大值时，说明可以凑齐j，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    // 递推公式：dp[j] = min(dp[j - coins[i] + 1, dp[j]);
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

}
