package com.charlie.leetcode.array;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/19 19:24
 * @Description: 数组的最大美丽值
 */
public class Solution2779 {

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        // x - k, x, x + k
        // y - k, y, y + k
        // 满足条件： x + k >= y - k  ->  y - x <= 2 * k
        // 排序后，每个元素的可变化范围也是有序的，要想判断是否能变为相同的元素，只需要x+k是否覆盖y-k即可
        int ans = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println(maximumBeauty(new int[]{52, 34}, 21));
        System.out.println(maximumBeauty(new int[]{48, 93, 96, 19}, 24));
        System.out.println(maximumBeauty(new int[]{51, 91, 92, 16, 65}, 27));
    }
}
