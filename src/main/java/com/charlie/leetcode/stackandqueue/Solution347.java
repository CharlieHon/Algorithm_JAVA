package com.charlie.leetcode.stackandqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前K个高频元素
 */
public class Solution347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));    // [2, 1]
    }

    /**
     *
     * @param nums 整数数组
     * @param k 前k个
     * @return 返回数组中出现频率前k高的元素，可以按任意顺序返回
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 使用map统计数组中的数出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 使用优先级队列，队列中保存二元组(num, cnt)，通过元素出现频率从小打到排序(小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
            if (pq.size() > k) {    // 队列中元素个数超过k，移除队首(即出现频率最低)元素
                pq.poll();
            }
        }
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }

}
