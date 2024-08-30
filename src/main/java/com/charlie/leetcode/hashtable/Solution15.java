package com.charlie.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>三数之和</h1>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>注意：答案中不可以包含重复的三元组。</p>
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = treeSum(nums);
        System.out.println("lists=" + lists);
    }

    public static List<List<Integer>> treeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 因为已经排序，所以当一个数大于0时，不可能存在三数和等于0，结束
            if (nums[i] > 0) break;
            // 对i去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int sum;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 因为此时，i不变，如果nums[left]或nums[right]与前一个遍历的重复，则结果一定重复，此时跳过
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
