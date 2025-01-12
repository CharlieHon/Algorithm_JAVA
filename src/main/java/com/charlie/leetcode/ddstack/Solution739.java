package com.charlie.leetcode.ddstack;

import java.util.Stack;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/12 21:20
 * @Description: 每日温度【单调栈】
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                    int j = stack.pop();
                    res[j] = i - j;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
