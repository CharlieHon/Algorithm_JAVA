package com.charlie.leetcode.ddstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/12 22:13
 * @Description: 下一个更大元素Ⅱ
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        // stack.push(0);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.empty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
