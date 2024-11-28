package com.charlie.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: charlie
 * @date: Created in 2024/11/28 13:55
 * @description: 分发饼干：每个孩子最多只能给一块饼干
 */
public class Solution455 {
    /**
     *
     * @param g 胃口值
     * @param s 饼干尺寸
     * @return 最多能满足多少个小孩胃口
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int start = 0;  // 胃口索引

        // 小饼干满足小胃口
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (g[start] <= s[i]) {
                res++;
                start++;
            }
        }

        return res;
    }
}
