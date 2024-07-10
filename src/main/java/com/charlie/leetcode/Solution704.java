package com.charlie.leetcode;

/**
 * <h3>二分查找</h3>
 */
public class Solution704 {

    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // [left, right]
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        // 未找到目标值
        return -1;
    }

}
