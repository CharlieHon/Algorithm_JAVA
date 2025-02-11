package com.charlie.leetcode.math;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/11 19:28
 * @Description: 多数元素
 * 找出数组中超过 ⌊ n/2 ⌋ 次的元素，其中 n 为数组的长度，且题目保证存在答案
 *
 * 推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的 票数和 >0 。
 * 推论二： 若数组的前 a 个数字的 票数和 =0 ，则 数组剩余 (n−a) 个数字的 票数和一定仍 >0 ，即后 (n−a) 个数字的 众数仍为 x 。
 */
public class Solution169 {
    // 投票法
    public int majorityElement(int[] nums) {
        int pre = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) pre = num;
            vote += pre == num ? 1 : -1;
        }
        return pre;
    }
}
