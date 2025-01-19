package com.charlie.leetcode.array;

import java.util.Arrays;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/19 14:52
 * @Description: 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数
 */
public class Solution611 {

    /**
     * 对于三角形的三条边 1 <= a <= b <= c 有：
     * a + b > c
     * a + c > b
     * b + c > a
     *
     * @param nums 三角形边长可能选项
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        // 🔺最外层循环枚举最大的一条边
        for (int k = 2; k < nums.length; k++) {
            int i = 0, j = k - 1;
            // 因为 a < b + c, b < a + c
            // 所以只需要满足 a + b > c 即可构成三角形
            while (i < j) {
                if (nums[i] + nums[j] <= nums[k]) {
                    i++;
                } else {
                    ans += j - i;
                    j--;
                }
            }
        }
        return ans;
    }

}
