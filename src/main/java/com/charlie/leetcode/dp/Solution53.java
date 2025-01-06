package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/6 10:40
 * @Description: 最大子序和
 */
public class Solution53 {

    // dp法
    public int maxSubArray(int[] nums) {
        // dp[i]表示以nums[i]结尾的连续子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if (0 < dp[i - 1]) {
            //     dp[i] = dp[i - 1] + nums[i];
            // } else {
            //     dp[i] = nums[i];
            // }
            // 状态转移公式
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 贪心法
    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
