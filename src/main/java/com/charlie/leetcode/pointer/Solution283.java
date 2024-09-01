package com.charlie.leetcode.pointer;

import java.util.Arrays;

/**
 * <h1>移动零</h1>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        removeZeros2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 一次遍历法，思路同快排，将不等于0的元素放在左边，等于0的元素放到右边
     * @param nums
     */
    public static void removeZeros3(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (j > i) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }

    /**
     * 思路：两次遍历，第一次去除0元素，第二次将后面的元素全部置0
     */
    public static void removeZeros2(int[] nums) {
        // 第一次遍历，去除0
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        // 第2次遍历，从i开始将数组元素全部置0
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    // 复杂，弃之
    public void moveZeros1(int[] nums) {
        // j指向数组最右侧非0处
        int j = nums.length - 1;
        while (j >= 0 && nums[j] == 0) j--;
        //
        for (int i = j - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int k = i;
                while (k < j) {
                    nums[k] = nums[k + 1];
                    k++;
                }
                nums[j--] = 0;
            }
        }
    }

}
