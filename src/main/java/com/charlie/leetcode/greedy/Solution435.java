package com.charlie.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: charlie
 * @date: Created in 2024/12/6 10:24
 * @description: 无重叠区间
 */
public class Solution435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // < 表示区间i和区间i-1重叠，需要擦除其中一个区间
            // 更新interval[i][1] 表示，擦除的是二者中 右边界大的那个。
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
            }
        }

        return count;
    }

}
