package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/20 20:10
 * @Description: 爱吃香蕉的珂珂
 */
public class Solution875 {

    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int right = piles[0];
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // 因为 n <= h 所以当 k = 最大堆香蕉的个数时一定能吃完
        // 而二分查找的的范围内是不确定的，所以范围选取为 [1, max - 1]
        right--;
        int left = 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // h小时能吃完所有香蕉
            if (check(piles, h, mid)) {
                // right + 1 都满足
                right = mid - 1;
            } else {
                // left - 1 都不满足
                left = mid + 1;
            }
        }
        // ..., right, left, ...
        return left;
    }

    // (a / b)向上取整 == ((a - 1) / b) 向下取整 + 1
    private static boolean check(int[] piles, int h, int k) {
        int sum = piles.length;
        for (int pile : piles) {
            sum += (pile - 1) / k;
            if (h < sum) {
                // 吃不完
                return false;
            }
        }
        return true;
    }

}
