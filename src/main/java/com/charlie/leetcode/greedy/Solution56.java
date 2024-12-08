package com.charlie.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: charlie
 * @date: Created in 2024/12/8 12:34
 * @description: 合并区间
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {
        // 按照左边界从小到大排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];     // 合并后区间左边界
        int right = intervals[0][1];    // 合并后组件最大右边界
        for (int i = 1; i < intervals.length; i++) {
            if (right <= intervals[i][0]) { // 更新最大有边界
                right = Math.max(right, intervals[i][1]);
            } else {
                // 合并区间就是将更新后的区间范围放入res
                res.add(new int[] {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        res.add(new int[] {left, right});
        return res.toArray(new int[res.size()][]);
    }
}
