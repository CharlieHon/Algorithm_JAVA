package com.charlie.leetcode.array;

import java.util.Arrays;

/**
 * <h3>数组的度</h3>
 * 数组的度是指数组中任意一个元素出现频率的最大值
 */
public class Solution697 {

    private static int N = 50_000;

    // 找出与数组nums度相同的子数组的最小长度
    public static int findShortestSubArray(int[] nums) {
        int[] cnt = new int[N]; // 统计数出现的频率
        int[] first = new int[N];   // 数第一次出现的下标
        int[] last = new int[N];    // 数最后一次出现的下标
        Arrays.fill(first, -1);
        int n = nums.length;
        int du = 1; // 度
        int result = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            du = Math.max(du, ++cnt[num]);
            if (first[num] == -1) {
                first[num] = i;
            }
            last[num] = i;
        }

        return result;
    }

}
