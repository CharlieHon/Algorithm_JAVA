package com.charlie.leetcode.stackandqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <h3>滑动窗口最大值</h3>
 * 使用单调队列，队列中元素值单调递减，队头元素即为该滑动窗口区间内的最大值。
 * <lo>
 *     <li>
 *         当窗口滑动时，如果窗口删除的元素是队首元素，即
 *     </li>
 * </lo>
 */
public class Solution239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length - k + 1;
        int[] result = new int[len];
        MyQueue1 queue = new MyQueue1();

        // 先将前k个元素加入队列
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        int idx = 0;
        result[idx++] = queue.peek();

        // 将后续元素加入队列
        for (int i = k; i < nums.length; i++) {
            // 移除元素是否和队列头元素相同
            queue.poll(nums[i - k]);
            // 新入元素加入队列
            queue.offer(nums[i]);
            // 当前窗口最大值
            result[idx++] = queue.peek();
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

}

/**
 * 单调队列
 */
class MyQueue1 {

    private Deque<Integer> deque = new LinkedList<>();

    // 移除元素
    public void poll(int val) {
        if (!deque.isEmpty() && deque.peekFirst() == val) {
            deque.pollFirst();
        }
    }

    // 添加元素
    public void offer(int val) {
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.pollLast();
        }
        deque.offerLast(val);
    }

    // 获取开头元素
    public int peek() {
        return deque.peekFirst();
    }

}
