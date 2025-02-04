package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/4 15:43
 * @Description: 二叉搜索树最近节点查询
 *
 */
class Solution2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        int n = path.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int target : queries) {
            int index = lowerBound(path, target);
            // <=x 的最大值 >=x 的最小值
            if (index == n) {
                ans.add(List.of(path.get(n -1), -1));
            } else if (index == -1) {
                ans.add(List.of(-1, path.get(0)));
            } else {
                // ans.add(List.of(path.get(index), path.get(index)));
                if (path.get(index) == target) {
                    ans.add(List.of(path.get(index), path.get(index)));
                } else if (index != 0) {
                    ans.add(List.of(path.get(index - 1), path.get(index)));
                } else {
                    ans.add(List.of(-1, path.get(index)));
                }
            }
        }

        return ans;
    }

    private void dfs(TreeNode p, List<Integer> path) {
        if (p == null) {
            return;
        }
        dfs(p.left, path);
        path.add(p.val);
        dfs(p.right, path);
    }

    private int lowerBound(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
