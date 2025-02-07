package com.charlie.leetcode.hashtable;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/7 19:18
 * @Description: 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * n = nums.length，则缺失的第一个正数范围是 [1, n + 1]
 * 因此，可以将原数组当作哈希表使用，使得 正数x 位于坐标 x - 1 处，即 nums[i] = i + 1
 * 则调整后，遍历数组时，如果nums[i] != i + 1，则 i + 1 是第一个缺失的正数，否则是 n + 1
 */
class Solution41 {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int ans = firstMissingPositive(nums);
        // System.out.println(Arrays.toString(nums));
        System.out.println("ans=" + ans);
    }

}
