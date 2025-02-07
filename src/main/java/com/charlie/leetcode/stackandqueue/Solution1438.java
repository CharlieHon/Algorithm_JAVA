package com.charlie.leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/7 13:08
 * @Description: 绝对差不超过限制的最长连续子数组的长度
 * <p>
 * 给你一个整数数组 nums 和一个整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [2, 4] 满足条件
 *
 *
 * 提示：因为要维护窗口中的最大值和最小值，因此使用两个队列
 */
class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int ans = 0;
        for (int left = 0, right = 0; right < n; right++) {
            // 1. 入
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right]) {
                maxQ.pollLast();
            }
            maxQ.offer(right);

            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right]) {
                minQ.pollLast();
            }
            minQ.offer(right);

            // 2. 出
            while (left <= right && nums[maxQ.peek()] - nums[minQ.peek()] > limit) {
                if (left == minQ.peek()) {
                    minQ.poll();
                }
                if (left == maxQ.peek()) {
                    maxQ.poll();
                }
                left++;
            }

            // 3. 记录答案
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    // TreeMap维护有序键
    public int longestSubarray2(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int ans = 0;
        for (int left = 0, right = 0; right < n; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > limit) {
                // 注意：不符合条件时移动滑动窗口，移除的是 left 处元素
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
