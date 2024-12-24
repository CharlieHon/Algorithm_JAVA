package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/24 11:15
 * @Description: 零钱兑换Ⅱ
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 */
public class Solution518 {

    public int change(int amount, int[] coins) {
        // 定义：dp[i] 总金额为 i 时的组合数
        int[] dp = new int[amount + 1];
        // 初始化：背包容量为0时，默认有一种组合方式
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //                 不放coin[i]  +  放coin[i]
                // 递推公式：dp[j] = dp[j] + dp[j - coin[i]];
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
