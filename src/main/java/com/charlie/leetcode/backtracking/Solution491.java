package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h3>非递减子序列</h3>
 */
public class Solution491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) {
            return res;
        }

        backtracking(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
        // 当节点数>=2时，放入结果集（题目要求）
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
            // 注意：这里不 return; 因为要遍历所有节点，还要往深层递归
        }

        // 注意：这里的set只记录本层已经使用过的元素，因为每次深度上递归调用backtracking时都会重新创建set
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 如果当前元素 < 上一个元素 or 或者当前元素已经使用过，则层剪枝！
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
