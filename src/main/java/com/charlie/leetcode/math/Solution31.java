package com.charlie.leetcode.math;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/11 20:33
 * @Description: 下一个排列
 *
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列
 * 例如 [1, 2, 3] 的排列有 [1, 3, 2], [2, 1, 3], [2, 3, 1]
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        for (int i = n - 2; i >= 0; i--) {
            // 从后往前找，找到第一个相邻升序对
            if (nums[i] < nums[i + 1]) {
                // 再从后往前找，找第一个大于 nums[i] 的元素，最坏情况是 nums[i + 1]
                for (int j = n - 1; i < j; j--) {
                    if (nums[j] > nums[i]) {
                        // 交换 nums[i] 和 nums[j]
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;

                        // 翻转（升序排序） [i + 1, n - 1] 范围内的元素
                        reverse(nums, i + 1, n - 1);
                        return;
                    }
                }
            }
        }
        // 如果没找到升序对，说明数组中降序排序，则返回最小的结果，即升序排序结果
        reverse(nums, 0, n - 1);
    }

    // 反转数组 [start,end] 范围的元素
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
