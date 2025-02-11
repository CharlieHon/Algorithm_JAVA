package com.charlie.leetcode.math;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/11 21:34
 * @Description: 寻找重复数
 *
 * 数组大小为 n + 1 ，数组中元素的范围是 [1, n]，则必然后一个或多个元素出现次数 >= 2
 * 题目假设 有且仅有一个元素出现次数 >=2 ，请你找出这个元素
 *
 * 思路：从理论上讲，数组中如果有重复的数，那么就会产生多对一的映射，这样，形成的链表就一定会有环路
 *      所以类似   Solution142. 环状链表Ⅱ  使用快慢指针
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = nums[0];
                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}
