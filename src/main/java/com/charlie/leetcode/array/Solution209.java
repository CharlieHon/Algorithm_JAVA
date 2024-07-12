package com.charlie.leetcode.array;

/**
 * <h3>长度最小的子数组</h3>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 */
public class Solution209 {

    /**
     * 暴力法
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * <h1>移动区间法</h1>
     * 外层使用for循环遍历数组，索引j指示区间的结束位置。内层while循环判断区间和是否符合条件，通过 sum -=
     * @param s 目标区间和
     * @param nums 数组
     * @return 返回区间和 >= s 的最小区间长度；如果不存在，则返回0
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE; // 最终结果，即 s>=target的最小长度
        int sum = 0;    // 滑动窗口数值之和
        int i = 0;      // 滑动窗口起始位置
        int subLength = 0;  // 滑动窗口长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                sum -= nums[i++];   // 滑动窗口的精髓，不断变更i(子序列的起始位置)
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
