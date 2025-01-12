package com.charlie.leetcode.ddstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/12 21:50
 * @Description: 下一个更大元素Ⅰ
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        // Arrays.fill(res, -1);

        // nums1[i] -> nums2中比nums1[i]大的第一个元素值
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            while (!stack.empty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
