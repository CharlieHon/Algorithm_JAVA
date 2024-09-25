package com.charlie.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h3>下一个更大元素Ⅱ</h3>
 */
public class Solution503 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // 将所有结果初始化为-1，即没有比它更大的元素
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        // 遍历2遍数组，因为每个元素都需要找到下一个更大元素，如最后一个元素需要再循环一遍
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                // 找到比当前下标更大的元素，就弹出该下标，所以找的是下一个更大的，而非最大的
                int k = stack.pop();
                result[k] = nums[i % n];
            }
            // 每一步都入栈当前下标(%n)，上面while循环会出栈找到结果的
            stack.push(i % n);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        int[] ans = nextGreaterElements(nums);
        System.out.println("ans=" + Arrays.toString(ans));
    }

}
