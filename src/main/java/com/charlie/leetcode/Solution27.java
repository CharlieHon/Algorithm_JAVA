package com.charlie.leetcode;

import java.util.Arrays;

/**
 * <h3>移除元素</h3>
 */
public class Solution27 {

    /**
     * <h3>快慢指针</h3>
     * 快指针依次遍历数组，当快指针指向的元素非目标值时赋值给慢指针指向的位置，最后慢指针索引大小即移除目标值后数组的大小
     *
     * @param nums 原数组
     * @param val  目标移除值
     * @return 移除目标值后的数组
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 4, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println("size=" + arr.length);
        int val = 7;
        int size = removeElement(arr, val);
        System.out.println(Arrays.toString(arr));
        System.out.println("size=" + size);
    }

}
