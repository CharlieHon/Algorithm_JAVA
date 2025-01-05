package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/5 11:13
 * @Description: 最长公共子序列
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 元素相等，两字符串都推进
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 元素不相等，只推进一个，所以取二者的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] dp = new int[len2 + 1];

        for (int i = 1; i <= len1; i++) {

            int pre = dp[0];

            for (int j = 1; j <= len2; j++) {

                int curr = dp[j];

                if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
                    // dp[j] = Math.max(dp[j], dp[j - 1] + 1);
                    dp[j] = pre + 1;
                    System.out.println(text1.charAt(i - 1));
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = curr;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[len2];
    }

    public static void main(String[] args) {
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println("res=" + res);
    }
}
