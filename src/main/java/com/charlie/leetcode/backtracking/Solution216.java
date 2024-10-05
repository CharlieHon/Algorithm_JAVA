package com.charlie.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {

    private List<List<Integer>> res;
    private List<Integer> curr;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        curr = new ArrayList<>();
        backtracking(k, n, 1);
        return res;
    }

    private void backtracking(int k, int n, int start) {

        // 剪枝：[start, 9]区间里的数不够k个，就不用继续往下搜索
        if (10 - start < k) {
            return;
        }

        if (n == 0) {
            if (k == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        // 枚举[..., 7, 8, 9]
        // 规律：起点上界 + k = 10 ---> 起点上界 = 10 - k
        for (int i = start; i <= 10 - k; i++) {

            // 剪枝
            if (n - i < 0) {
                break;  // 跳过
            }

            curr.add(i);
            backtracking(k - 1, n - i, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

}
