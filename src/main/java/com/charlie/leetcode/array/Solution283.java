package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/15 13:32
 * @Description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 其实就是删除0元素，然后后面空位填充0
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
