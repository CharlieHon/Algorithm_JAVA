package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/4 10:55
 * @Description: 最长重复子数组
 */
public class Solution718 {

    // 动态规划：二维dp
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] 表示以 nums1[i - 1], nums2[j - 1] 结尾的最长连续子数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        dp[0][0] = 0;
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    // 动态规划：一维dp
    public int findLength3(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    // 🔺：注意不相等时要重新赋值0
                    dp[j] = 0;
                }
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }

    // 暴力法
    public int findLength2(int[] nums1, int[] nums2) {
        // i,j是数组比较的起始位置
        int res = 0;
        int subLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // subLength表示从i，j开始最长连续重复子数组
                subLength = 0;
                while (i + subLength < nums1.length && j + subLength < nums2.length && nums1[i + subLength] == nums2[j + subLength]) {
                    subLength++;
                }
                res = Math.max(res, subLength);
            }
        }
        return res;
    }
}
