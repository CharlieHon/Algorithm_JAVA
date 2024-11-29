package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/11/29 9:52
 * @description: 摆动序列
 */
public class Solution376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int currDiff = 0;   // 当前元素和下一个元素的差值 nums[i + 1] - nums[i]
        int preDiff = 0;    // 当前元素和前一个元素的差值 nums[i] - nums[i - 1]
        int result = 1;     // 默认最右侧有一个峰值

        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            // preDiff 取到0是考虑平坡的情况
            if ((preDiff >= 0 && currDiff < 0) || (preDiff <= 0 && currDiff > 0)) {
                result++;
                // 当有峰值出现时，更新 preDiff
                preDiff = currDiff;
            }
        }
        return result;
    }

}
