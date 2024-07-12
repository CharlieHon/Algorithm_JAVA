package com.charlie.leetcode.array;

import java.util.Arrays;

/**
 * <h3>有序数组的平方</h3>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class Solution977 {

    // 暴力法
    public int[] sortedSquared2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * <h3>双指针法</h3>
     * 思路：数组原来是非递减顺序，平方后最大值只能出现在两段。可以创建一个与原数组大小相同的数组，每次取出最大值
     * 赋值给新数组的最右端。
     * @param nums 原数组
     * @return 元素平方后排序数组
     */
    public static int[] sortedSquared(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int index = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                result[index--] = nums[j] * nums[j];
                j--;
            } else {
                result[index--] = nums[i] * nums[i];
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(arr));
        int[] sorted = sortedSquared(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
