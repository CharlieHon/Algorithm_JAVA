package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/3 10:40
 * @Description: 最长练习递增序列
 */
public class Solution674 {
    public static int findLengthOfLCIS(int[] nums) {
        // dp[i]表示以nums[i]为尾元素的最长连续子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 贪心法
    public static int findLengthOfLCIS2(int[] nums) {
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                // 连续记录
                count++;
            } else {
                // 不连续，count从头开始
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        int res = findLengthOfLCIS2(nums);
        System.out.println("res=" + res);
    }
}
