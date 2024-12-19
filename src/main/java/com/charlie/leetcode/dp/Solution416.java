package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/18 11:23
 * @Description: 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 要想分割出等和子集，数组所有元素和必须是偶数
        if ((sum & 1) == 1) {
            return false;
        }
        // 分出去的自己的和
        int target = sum / 2;
        // 将该和看成背包的容量，则问题等价于：当背包容量为target时，能否用nums中物品正好装满背包
        // nums中每个元素为物品的重量，同时也是物品的价值
        // 定义：dp[j]表示背包容量为j时，背包的重量，即所装物品的重量最大重量🔺
        // 🔺：因为 dp[j] <= j，所以下面要取max，尽可能多装，当 dp[target] == target 时表示正好装满
        //      又 target 为nums元素和的一半，所以说可以拆分
        int[] dp = new int[target + 1];

        // 一维dp模板
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; nums[i] <= j; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) {
                return true;
            }
        }

        return dp[target] == target;
    }
}
