package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/24 10:29
 * @Description: 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        int[][] dp = new int[m+1][n+1];
        // dp[0][0] = 0;

        for (String str : strs) {
            int zeroNum = zeroNum(str);
            int oneNum = str.length() - zeroNum;
            for (int i = m; zeroNum <= i; i--) {
                for (int j = n; oneNum <= j; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int zeroNum(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                ans++;
            }
        }
        return ans;
    }
}
