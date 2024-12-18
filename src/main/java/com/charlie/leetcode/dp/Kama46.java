package com.charlie.leetcode.dp;

import java.util.Scanner;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/17 11:12
 * @Description: 01背包问题
 */
public class Kama46 {

    // 使用一维dp数组
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] weight = new int[m];
        int[] value = new int[m];

        for (int j = 0; j < m; j++) {
            weight[j] = scanner.nextInt();
        }

        for (int j = 0; j < m; j++) {
            value[j] = scanner.nextInt();
        }

        // 定义：一维dp数组，dp[j]表示背包容量为j时，最大价值
        // 初始化:dp[0] = 0; 初始化均为0
        int[] dp = new int[n+1];
        // 🔺：先遍历m，即物品
        for (int i = 0; i < m; i++) {
            // 🔺：再遍历n，即背包容量
            // 遍历背包容量时，逆序遍历，避免重复放入第i个物品 value[i]
            for (int j = n; weight[i] <= j; j--) {
                // 递推公式：
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

    }

    /**
     * @param m      材料种类
     * @param n      背包容量
     * @param weight 材料重量
     * @param value  材料价值
     * @return 最大价值
     */
    public int solution(int m, int n, int[] weight, int[] value) {
        int[][] dp = new int[m][n + 1];
        // 定义：dp[i][j] 背包容量为j时，可选0~i个物品，最大价值
        // 递推公式：dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);

        // 初始化：第一行，背包容量从0到n时最大价值
        // for (int i = 0; i <= n; i++) {
        //     if (weight[0] <= i) {
        //         dp[0][i] = value[0];
        //     }
        // }
        for (int j = weight[0]; j <= n; j++) {
            dp[0][j] = value[0];
        }

        // i 为 背包索引
        for (int i = 1; i < m; i++) {
            // j为 背包容量大小
            for (int j = 1; j <= n; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[m - 1][n];
    }

}
