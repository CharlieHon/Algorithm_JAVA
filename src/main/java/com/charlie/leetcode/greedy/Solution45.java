package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/12/2 10:02
 * @description: 跳跃游戏Ⅱ
 */
public class Solution45 {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 1, 4};
        int result = jump(nums);
        System.out.println("result=" + result);
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int result = 0;
        // 本次能移动的最大范围
        int currRange = 0;
        // 下一跳后能移动的最大范围
        int maxRange = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 不断更新如果跳的话，跳后的最大范围
            maxRange = Math.max(i + nums[i], maxRange);
            // 当达到本次最大范围后，必须要跳了
            if (i == currRange) {
                result++;               // 次数+1
                currRange = maxRange;   // 这表示当前要跳到下一跳范围最大的那一索引上，更新跳后的最大可到范围
            }
        }

        return result;
    }
}
