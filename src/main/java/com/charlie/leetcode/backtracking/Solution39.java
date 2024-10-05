package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>组合总和</h3>
 *
 */
public class Solution39 {

    private List<List<Integer>> res;
    private List<Integer> path;

    /**
     *
     * @param candidates 无重复元素数组
     * @param target    目标和
     * @return  candidates中的数字可以无限制重复被选取
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (target <= 1) {
            return res;
        }
        path = new ArrayList<>();
        backtracking(candidates, target, 0);
        return res;
    }

    private void backtracking(int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target < 0) {   // 剪枝
                break;
            }

            path.add(nums[i]);

            // start从i开始，这样就可以连续取同一个数多次
            backtracking(nums, target - nums[i], i);

            path.remove(path.size() - 1);   // 回溯
        }

    }

}
