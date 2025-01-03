package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/3 10:32
 * @Description: 最长递增子序列
 */
public class Solution300 {
    public static int lengthOfLTS(int[] nums) {
        // 定义：dp[i] 表示以nums[i]为尾元素的最长递增子序列长度
        int[] dp = new int[nums.length];
        // 初始化：都为1
        Arrays.fill(dp, 1);
        // 记录最大值，因为最大值不一定是dp[nums.length - 1]
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 递推公式：
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // System.out.println(Arrays.toString(dp));
                }
            }
            // System.out.println("--------");
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = lengthOfLTS(nums);
        System.out.println("res=" + res);
    }
}
