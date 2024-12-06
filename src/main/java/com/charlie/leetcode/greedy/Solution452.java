package com.charlie.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: charlie
 * @date: Created in 2024/12/6 10:00
 * @description: 用最少数量的箭引爆气球
 */
public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        for (int i = 1; i < points.length; i++) {
            // 当前节点的左边界超过(>) 重叠区域最小有边界，计数+1
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                // 这里在原地！更新了重叠区域最小右边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return count;
    }

}
