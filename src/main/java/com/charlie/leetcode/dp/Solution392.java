package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/6 11:08
 * @Description: 判断子序列
 */
public class Solution392 {

    /**
     * dp：注意题目，字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串
     * s是t的子序列，所以如果要删除字符，只能从t中进行删除操作
     */
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // s[i - 1] == t[j - 1]
                    // 则ij同时移动
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // s[i - 1] ！= t[j - 1]
                    // 因为s是t的子序列，所以要由t进行删除操作即j-1
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }


    /**
     * 判断字符串s是否是t的子序列【双指针】
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
