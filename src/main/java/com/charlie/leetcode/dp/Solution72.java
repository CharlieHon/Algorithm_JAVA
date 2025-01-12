package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/6 15:12
 * @Description: 编辑距离
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示 word1[0,i] 到 word2[0,j] 的最小编辑距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 递推公式：
        // w1[i] == w2[j]: dp[i][j] = dp[i - 1][j - 1]
        // w1[i] != w2[j]: (dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2)

        // 初始化：dp[0][i]
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j] 删除word1
                    // dp[i][j - 1] 删除word2
                    // dp[i - 1][j - 1] 替换
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
