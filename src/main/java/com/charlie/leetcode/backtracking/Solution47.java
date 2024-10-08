package com.charlie.leetcode.backtracking;

import java.util.*;

/**
 * <h3>全排列Ⅱ</h3>
 * 给定一个可包含重复数字的序列 nums，按任意顺序返回所有不重复的全排列
 * 注意：序列中有重复元素，但是要求全排列中不能有重复，因此需要去重
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 对nums进行排序，相同元素相邻，便于去重
        Arrays.sort(nums);
        // 标记下标i处元素是否使用过
        boolean[] used = new boolean[nums.length];
        backtracking(nums, res, new ArrayDeque<>(), used);
        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        // 当路径中元素个数和数组相同时，即为一个全排列
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前值和前一个相等，并且在同一层上已经使用过前一个值，则层剪枝！
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // used[i - 1] == false 说明同一树层 nums[i - 1] 已经使用过
                // used[i - 1] == true 表示同一树枝上 nums[i - 1] 已经使用过。
                continue;
            }

            if (!used[i]) {
                path.offerLast(nums[i]);
                used[i] = true; // 置为true，再往深层递归，即同一树枝上used[i]为true表示使用过
                backtracking(nums, res, path, used);
                path.pollLast();
                used[i] = false;    // 回溯，则同一树层上，used[i]==false 则表示已经使用过
            }
        }
    }
}
