package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/17 15:04
 * @Description: 最小覆盖子串
 * 滑动窗口
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        char[] cs = s.toCharArray();
        int n = s.length();
        char[] ct = t.toCharArray();
        // cnt[x] = cntS[x] - cntT[x]; 子串x出现次数减去t中出现次数
        int[] cnt = new int[128];
        // less表示字符串t中还有几种字符没有被子串覆盖
        int less = 0;
        for (char c : ct) {
            if (cnt[c] == 0) {
                less++;
            }
            cnt[c]--;
        }

        int ansLeft = -1, ansRight = n;
        int left = 0;
        for (int right = 0; right < n; right++) {
            cnt[cs[right]]++;
            // cnt[x]计数归0，表示t中x字符被字符覆盖
            if (cnt[cs[right]] == 0) {
                less--;
            }
            while (less == 0) {
                if (right - left < ansRight - ansLeft) {
                    ansRight = right;
                    ansLeft = left;
                }
                if (cnt[cs[left]] == 0) {
                    less++;
                }
                cnt[cs[left]]--;
                left++;
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}
