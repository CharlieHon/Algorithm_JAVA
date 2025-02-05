package com.charlie.leetcode.treenode;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/5 13:50
 * @Description: 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 */
class Solution1373 {

    private int ans;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 后序遍历
    // 返回以p为根节点的子树【最小值，最大值，总和】，根据总和判断以p为节点的子树是否是搜索二叉树BST
    private int[] dfs(TreeNode p) {
        if (p == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        int[] left = dfs(p.left);
        int[] right = dfs(p.right);

        int x = p.val;
        // 以p为节点的子树不是BST
        if (x <= left[1] || x >= right[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        // 以p为节点的子树是BST，计算以p为节点的子树的最大键值和
        int sum = left[2] + right[2] + x;
        ans = Math.max(ans, sum);
        return new int[] {Math.min(left[0], x), Math.max(right[1], x), sum};
    }

}
