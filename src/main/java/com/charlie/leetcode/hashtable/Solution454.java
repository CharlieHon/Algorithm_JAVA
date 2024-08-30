package com.charlie.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>四数相加Ⅱ</h1>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class Solution454 {

    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (m1.containsKey(n1 + n2)) {
                    // 如果已有，则加1
                    m1.put(n1 + n2, m1.get(n1 + n2) + 1);
                } else {
                    // 如果没有，则新加入，即置1
                    m1.put(n1 + n2, 1);
                }
            }
        }

        int res = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                if (m1.containsKey(-(n3+n4))) {
                    res += m1.get(-(n3+n4));
                }
            }
        }
        return res;
    }

}
