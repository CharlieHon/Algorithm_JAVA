package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/9 12:43
 * @Description: 删除有序数组中的重复项Ⅱ
 * 原地删除数组中重复次数超过2次的元素，并返回修改后数组的长度
 */
public class Solution80 {
    // 因为数组有序，可以维护一个单调栈，将遍历到的元素与栈顶的下一个元素比较，如果不相等，则该数值出现次数不会超过2
    public int removeDuplicates(int[] nums) {
        int stackSize = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[stackSize - 2]) {
                nums[stackSize++] = nums[i];
            }
        }
        return stackSize;
    }
}
