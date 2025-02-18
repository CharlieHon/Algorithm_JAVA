package com.charlie.leetcode.treenode;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/18 10:52
 * @Description: 二叉树的直径
 */
class Solution543 {

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    // 二叉树最大深度
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        // 🔺：在求最大深度的过程中不断记录 **当前节点** 左右子树的最大深度，更新 ans（最大直径）
        ans = Math.max(ans, l + r);
        // getDepth返回值是 root 节点的最大深度
        return Math.max(l, r) + 1;
    }

}
