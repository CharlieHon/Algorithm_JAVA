package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/6 14:19
 * @Description: 两个字符串的删除操作
 */
public class Solution583 {
    public static int minDistance(String word1, String word2) {
        // dp[i][j] 表示以word1[i-1]结尾的单词到以word2[j-1]结尾的单词，需要的步数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 相等，不需要再进行额外操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不相等，在其中任意一个字符上进行删除操作，选择最小的那个
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int res = minDistance(word1, word2);
        System.out.println("res=" + res);
    }
}
