package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/14 16:57
 * @Description: x的平方根
 *  0 <= x < 2^31 - 1
 * 题意：m^2 <= x，返回 m 的最大值
 *
 * 因为 46340 * 46340 <= 2147483647 < 46341 * 46341
 * 所以，为了减少比较次数，m最大可以取 46340
 */
public class Solution69 {
    public static int sqrt(int x) {
        int left = 0, right = Math.min(x, 46340);
        // [left, right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (mid * mid <= x) {
                // 小于等于,..., left
                left = mid + 1;
            } else {
                // right,..., 大于
                right = mid - 1;
            }
        }
        return right;
    }
}
