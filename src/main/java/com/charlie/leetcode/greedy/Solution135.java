package com.charlie.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: charlie
 * @date: Created in 2024/12/4 9:47
 * @description: 分发糖果，相邻两个评分更高的孩子会获得更多的水果
 * @solution: 思路：先考虑左边，再考虑右边
 */
public class Solution135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }

        // 分发的糖果，初始化全为1
        int[] candyVec = new int[n];
        Arrays.fill(candyVec, 1);

        // 考虑右边分数比左边分数大时，右边糖果数 = 左边糖果数 + 1
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candyVec[i] = candyVec[i] + 1;
            }
        }

        // 再考虑左边分数比右边分数大时，此时要保证
        //      i处糖果数比左边大(candyVec[i]满足)，同时比右边大一，所以贪心策略取两者最大值
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        int result = 0;
        for (int c : candyVec) {
            result += c;
        }
        return result;
    }

}
