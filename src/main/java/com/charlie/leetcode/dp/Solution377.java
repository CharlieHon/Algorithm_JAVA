package com.charlie.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/25 11:01
 * @Description: 组合总和Ⅳ
 */
public class Solution377 {

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j) {
                    dp[j] += dp[j - nums[i]];
                }
                System.out.println(Arrays.toString(dp));
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;

        int res = combinationSum4(nums, target);
        System.out.println("res=" + res);   // 7
    }

}
