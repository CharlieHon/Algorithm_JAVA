package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/15 16:33
 * @Description: 长度最小的子数组：找出数组中元素和大于等于target的连续子数组的最小长度
 *
 * 滑动窗口（快慢指针）
 */
public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        // 滑动窗口的起始位置（慢指针）
        int i = 0;
        // [i, j]窗口的元素总和
        int sum = 0;
        // j为滑动窗口的结束位置（快指针）
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (target <= sum) {
                // 更新最小窗口长度
                res = Math.min(res, j - i + 1);
                // 移动慢指针，缩小窗口范围
                sum -= nums[i];
                i++;
                // 退出循环后的[i, j]范围元素和小于target
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
