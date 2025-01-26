package com.charlie.leetcode.treenode;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/26 22:10
 * @Description: 节点与其祖先之间的最大差值
 */
public class Solution1026 {
    private static int ans;
    public static int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 计算以p为根节点的子数中，节点的最大值和最小值，并更新ans
    private static int[] dfs(TreeNode p) {
        if (p == null) {
            // 空节点不影响结果
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = dfs(p.left);
        int[] right = dfs(p.right);
        int mn = Math.min(p.val, Math.min(left[0], right[0]));
        int mx = Math.max(p.val, Math.max(left[1], right[1]));
        // 🔺注意：ans求得是以节点p为根节点的最大V值！
        ans = Math.max(ans, Math.max(p.val - mn, mx - p.val));
        return new int[]{mn, mx};
    }
}
