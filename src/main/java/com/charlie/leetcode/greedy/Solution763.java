package com.charlie.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: charlie
 * @date: Created in 2024/12/8 12:39
 * @description: 划分字母区间
 */
public class Solution763 {

    public List<Integer> partitionLabels(String s) {
        // 每个字母出现的最远位置
        int[] position = new int[26];
        for (int i = 0; i < s.length(); i++) {
            position[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;    // 每个划分片段的左右端点
        for (int i = 0; i < s.length(); i++) {
            // 更新已遍历字母的最远位置
            right = Math.max(right, position[s.charAt(i) - 'a']);
            if (i == right) {   // 当前左边等于已遍历字母最远位置时，即找到一个区间片段
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }

}
