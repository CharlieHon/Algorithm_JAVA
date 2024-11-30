package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/11/30 13:44
 * @description: 最大子数组和
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // 当前累加和
        int currSum = 0;
        // 记录最大连续子数组和
        int maxSum = Integer.MIN_VALUE; // 初始化为最小整数

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            // 只要当前累加和比最大累加和大，就更新最大累加和
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            // 当前累加和 < 0 ，就从0重新开始累加。因为负数一定会使后面的累加变小
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

}
