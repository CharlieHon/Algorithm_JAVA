package com.charlie.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/18 10:16
 * @Description: 区间内查询数字的频率
 *
 * 对于 arr 中的每个数，计算其在 arr 中出现的下标（位置）
 * 统计 x 在下标 [left, right] 范围内出现的次数，等价于 在统计 x 出现的下标中 在 [left, right] 的个数
 * 可以使用 二分查找 lowerBound(indexRange, right + 1) - lowerBound(indexRange, left)
 */
public class Solution2080 {
    private Map<Integer, List<Integer>> cache;

    public Solution2080(int[] arr) {
        cache = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            cache.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> a = cache.get(value);
        if (a == null) {
            return 0;
        }
        //      > value 等价于 >= value + 1
        //                                      >= value
        return lowerBound(a, right + 1) - lowerBound(a, left);
    }

    private int lowerBound(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
