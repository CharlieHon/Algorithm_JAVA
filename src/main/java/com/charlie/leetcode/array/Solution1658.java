package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/20 12:44
 * @Description: 将x减到0的最小操作数（正难则反）
 *对于给定整数数组nums，每一次操作可以从数组最右边或最左边删除一个元素，然后从x中减去该元素的纸
 * 求将x减为0的最小操作次数，如果x不能减为0，则返回-1。
 */
public class Solution1658 {

    // 逆向思维：求 nums 数组中和为 target(target = sum - x) 的最长子数组（连续）
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }

        int ans = -1;
        int sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (target < sum) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                // 最小删除数 ——> 最长子数组长度
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : nums.length - ans;
    }
}
