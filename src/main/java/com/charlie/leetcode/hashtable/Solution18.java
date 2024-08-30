package com.charlie.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>四数之和</h1>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class Solution18 {

    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = fourSum(arr, target);
        System.out.println("lists=" + lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        // 卡一下数组长度，没有条件的返回新建对象 new ArrayList<>();
        if (len < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < len - 3; i++) {
            // 已经不符合条件的，剪枝。比较的是nums[i]和0
            if (nums[i] > target && nums[i] > 0) {
                break;
            }
            // i去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                // j剪枝，nums[i] + nums[j] > 0
                if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0) {
                    break;
                }
                // j去重，和前面的比
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                long sum;
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (target < sum) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }

}
