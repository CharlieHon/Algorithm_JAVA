package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/8 19:52
 * @Description: 最长回文子序列
 */
public class Solution516 {

    public static int longestPalindromeSubseq(String s) {
        // dp[i][j] 表示 s[i, j] 范围内最长的回文子序列的长度是 dp[i][j]
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; 0 <= i; i--) {
            // 初始化
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

}
