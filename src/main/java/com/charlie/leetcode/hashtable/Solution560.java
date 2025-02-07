package com.charlie.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/7 10:34
 * @Description: 和为K的子数组
 *
 * 前缀和+哈希表：数组中有负数，使用滑动窗口的话不是单调的，不行！
 */
class Solution560 {

    // 遍历一遍数组，在遍历数组时即计算前缀和+统计频率
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
        // 因为遍历nums是从第一个元素开始的，需要单独维护没有元素时的前缀和
        map.put(0, 1);
        for (int x : nums) {
            preSum += x;
            ans += map.getOrDefault(preSum - k, 0);
            map.merge(preSum, 1, Integer::sum);
        }
        return ans;
    }

    // 遍历两边数组
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // i, i +1, ..., j - 1
        // s[j] - s[i] = k -> s[i] = s[j] - k
        //
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            // if (map.containsKey(preSum[i] - k)) {
            // ans += map.get(preSum[i] - k);
            // }
            ans += map.getOrDefault(preSum[i] - k, 0);
            map.merge(preSum[i], 1, Integer::sum);
        }
        return ans;
    }
}
