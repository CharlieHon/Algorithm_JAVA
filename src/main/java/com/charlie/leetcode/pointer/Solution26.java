package com.charlie.leetcode.pointer;

import java.util.Arrays;

/**
 * <h1>删除有序数组中的重复项</h1>
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数
 */
public class Solution26 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 2, 3};
        int len = removeDuplicates(nums);
        System.out.println("len=" + len);   // 4
        System.out.println(Arrays.toString(nums));  // [0, 1, 2, 3, ...]
    }

    /**
     * 快慢指针法
     * @param nums 原数组，非严格递增，即有重复值
     * @return 去重后的元素个数
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // i指向新数组(原地去重数组)最右侧
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

}
