package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/19 18:58
 * @Description: 找到最长的半重复子字符串
 */
public class Solution2730 {

    // 题目要求范围内只有一对相邻字符，所以可以用一个record记录第一对出现的位置
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1;
        int record = -1;

        for (int left = 0, right = 1; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                left = record + 1;
                record = right - 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int longestSemiRepetitiveSubstring2(String s) {
        int ans = 0;
        int record = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 只要当前字符与前一个字符相同，就出现了一对相邻字符
            if (right > 0 && s.charAt(right) == s.charAt(right - 1)) {
                record++;
            }
            while (record > 1) {
                left++;
                if (s.charAt(left) == s.charAt(left - 1)) {
                    record--;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
