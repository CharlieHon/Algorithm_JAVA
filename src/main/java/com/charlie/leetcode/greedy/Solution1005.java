package com.charlie.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: charlie
 * @date: Created in 2024/12/2 10:50
 * @description: K次取反后最大化的数组和
 */
public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        // 先将尽可能多个负数，转为正数
        for (int i = 0; i < len && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // 到这里k可能用完，有可能没用完
        // k % 2 == 1 表示：k没用完，且为奇数。此时数组中全是非负整数，
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0]; // 则使用最小的正数或者0消耗完k
        }

        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}
