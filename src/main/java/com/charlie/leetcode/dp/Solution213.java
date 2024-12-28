package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/28 10:42
 * @Description: 打家劫舍
 * 其它同198，不同点在于房子围城一个圈，收尾不能同时偷。数组成环，考虑以下三种情况：
 * 1. 不考虑首尾元素
 * 2. 不考虑尾元素
 * 3. 不考虑首元素
 * 情况2和情况3包含了情况1，只需要考虑情况2和3，取最大结果即可
 */
public class Solution213 {

    public int rob(int[] nums) {
        // 只有一家的话，可以偷
        if (nums.length == 1) {
            return nums[0];
        }
        // 如数组长度为5: 0, 1, 2, 3, 4
        // [0, 4):      0, 1, 2, 3, x
        // [1, 5):      x, 1, 2, 3, 4
        int res1 = robHelper(nums, 0, nums.length - 1);
        int res2 = robHelper(nums, 1, nums.length);
        return Math.max(res1, res2);
    }

    // [start, end)
    private int robHelper(int[] nums, int start, int end) {
        // len = end - start
        int[] dp = new int[end - start + 2];
        for (int i = start; i < end; i++) {
            dp[i - start + 2] = Math.max(dp[i - start + 1], dp[i - start] + nums[i]);
        }
        return dp[end - start + 1];
    }
}
