package com.charlie.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/18 14:34
 * @Description: 最长连续序列
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curr = num + 1;
            while (set.contains(curr)) {
                curr++;
            }
            res = Math.max(res, curr - num);
        }
        return res;
    }
}
