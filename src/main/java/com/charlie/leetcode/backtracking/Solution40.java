package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h3>组合总数Ⅱ</h3>
 */
public class Solution40 {

    /**
     *
     * @param candidates 有重复数组
     * @param target 目标和
     * @return 组合不能重复
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target < nums[i]) {
                break;
            }
            // i>start表示当前层，因此这里就是当前树层存在相同元素时直接跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, target - nums[i], i + 1, res, path);
            path.remove(path.size() - 1);
        }

    }

}
