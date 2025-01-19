package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/19 21:10
 * @Description: 最大连续1的个数Ⅲ
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,(1),1,1,1,1,(1)]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 思路：[left, right]范围元素在0的个数<k时的最大长度
 */
public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        // [left, right]范围内0的个数
        int cnt0 = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            // [left, right] 内0的个数
            cnt0 += 1 - nums[right];
            while (cnt0 > k) {
                if (nums[left] == 0) {
                    cnt0--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
