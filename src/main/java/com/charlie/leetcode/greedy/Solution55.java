package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/12/1 10:42
 * @description: 跳跃游戏
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // coverRange表示覆盖范围
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) { // i <= coverRange, 是能移动的最大范围
            // 每次移动时更新覆盖最大覆盖范围
            coverRange = Math.max(i + nums[i], coverRange);
            // 只要最大覆盖范围包括或超过数组边界，就说明能达到终点
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    // myCode
    public boolean canJump2(int[] nums) {

        int currCover = 0;
        int maxCover = 0;
        for (int i = 0; i < nums.length; i++) {
            currCover = i + nums[i];
            if (maxCover < currCover) {
                maxCover = currCover;
            }
            if (maxCover >= nums.length - 1) {
                return true;
            }
            if (i == maxCover) {
                break;
            }
        }
        return false;
    }
}
