package com.charlie.leetcode.treenode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/17 15:39
 * @Description: 路径总和Ⅲ
 *
 * 二叉树上的 前缀和 + 哈希表
 */
class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        return dfs(root, 0, targetSum, cnt);
    }

    private int dfs(TreeNode root, long s, int targetSum, Map<Long, Integer> cnt) {
        if (root == null) {
            return 0;
        }
        s += root.val;
        int ans = cnt.getOrDefault(s - targetSum, 0);
        cnt.merge(s, 1, Integer::sum);
        ans += dfs(root.left, s, targetSum, cnt);
        ans += dfs(root.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // 回溯，恢复现场
        return ans;
    }
}
