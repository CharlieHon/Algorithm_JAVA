package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>组合</h3>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
public class Solution77 {

    private List<List<Integer>> res;
    private List<Integer> curr;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        curr = new ArrayList<>();
        backtracking(n, k, 1);
        return res;
    }

    private void backtracking(int n, int k, int start) {
        // 当前集合中元素个数满足要求时，放入结果，结束递归
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        /*
          1. 数组大小为递归的宽度，可以通过剪枝操作避免不必要的遍历
          2. 目标大小k为递归的深度，也即递归的结束条件
        */

        // 剪枝：搜索起点的上界 + 要搜索元素的个数 - 1 = n
        for (int i = start; i <= (n - (k - curr.size()) + 1); i++) {
            curr.add(i);
            backtracking(n, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

}
