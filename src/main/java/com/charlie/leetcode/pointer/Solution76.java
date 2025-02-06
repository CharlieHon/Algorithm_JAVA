package com.charlie.leetcode.pointer;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/6 17:31
 * @Description: 最小覆盖子串
 *
 * 先统计字符串t中字母出现次数，在滑动窗口时统计子串中字母出现频率，比较 cntS 和 cntT
 * 如果 cntS 中字母出现次数都 >= cntT 中的，说明子串能够覆盖字符串t中所有字母。
 * 更新最小长度
 */
class Solution76 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] cntT = new int['z' + 1];
        for (int i = 0; i < t.length(); i++) {
            cntT[t.charAt(i)]++;
        }

        int minLeft = -1, minRight = s.length();
        int[] cntS = new int['z' + 1];

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            cntS[c]++;
            while (check(cntS, cntT)) {
                if (right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }
                cntS[s.charAt(left)]--;
                left++;
            }
        }
        return minLeft == -1 ? "" : s.substring(minLeft, minRight + 1);
    }

    private boolean check(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

}
