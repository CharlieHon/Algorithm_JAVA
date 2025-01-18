package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/18 12:35
 * @Description: 对称子串分割问题
 * 判断字符串是否可以分成若干个子串，使得每个子串都具有折叠对称性（即偶数长度的回文串）
 */
public class Mars379 {
    public static boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int n = s.length();
        // dp[i]表示前i个字符串是否是偶数回文串
        boolean[] dp = new boolean[n + 1];
        // 空串 "" 是偶数回文串
        dp[0] = true;

        for (int i = 2; i <= n; i += 2) {
            for (int j = 0; j < i; j += 2) {
                if (dp[j] && isPalindrome(s, j, i - 1)) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
