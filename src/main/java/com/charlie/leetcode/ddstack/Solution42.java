package com.charlie.leetcode.ddstack;


import java.util.Stack;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/13 11:39
 * @Description: 接雨水
 */
public class Solution42 {

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 第一个弹出的是中间凹槽底的高
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    // stack.peek()是凹槽左边的高
                    int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                    // 左边凹槽的高要在下一次弹出，作为下一个凹槽的底
                    int w = i - stack.peek() - 1;
                    res += h * w;
                }
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 暴力法（双指针优化）
     *
     * @param height 柱子高度
     * @return 雨水量
     */
    public int trap2(int[] height) {
        int res = 0;

        int[] maxLeft = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }

        int[] maxRight = new int[height.length];
        for (int j = height.length - 2; 0 <= j; j--) {
            maxRight[j] = Math.max(height[j + 1], maxRight[j + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            // 开头和最后的柱子接不到雨水
            if (i == 0 || i == height.length - 1) {
                continue;
            }

            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (0 < h) {
                res += h;
            }
        }
        return res;
    }
}
