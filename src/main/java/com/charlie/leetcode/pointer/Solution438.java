package com.charlie.leetcode.pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/6 16:01
 * @Description: 找到字符串中所有字母异位词
 */
class Solution438 {

    // 不定窗口，用一个cnt
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] cnt = new int['z' + 1];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i)]++;
        }

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c]--;
            while (cnt[c] < 0) {    // cnt[c] < 0 说明 S0 中c字母多了
                cnt[s.charAt(left)]++;
                left++;
            }

            // 上面已判断 子串S0中每个字母出现次数都 <= P
            // 此时 S0 长度和 P 相等，那么只能取 = ，所以此时S0是P的异位词
            if (right - left + 1 == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }

    // 不定窗口
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] cntP = new int['z' + 1];
        for (int i = 0; i < p.length(); i++) {
            cntP[p.charAt(i)]++;
        }

        int[] cntS0 = new int['z' + 1];
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            cntS0[c]++;
            while (cntS0[c] > cntP[c]) {
                cntS0[s.charAt(left)]--;
                left++;
            }

            // 上面已判断 子串S0中每个字母出现次数都 <= P
            // 此时 S0 长度和 P 相等，那么只能取 = ，所以此时S0是P的异位词
            if (right - left + 1 == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }

}
