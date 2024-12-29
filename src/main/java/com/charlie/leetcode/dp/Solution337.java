package com.charlie.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/29 16:38
 * @Description: 打家劫舍Ⅲ
 * 所有房屋排列类似一颗二叉树
 */
public class Solution337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {
            return root.val;
        }
        int[] ans = robTree(root);
        return Math.max(ans[0], ans[1]);
    }

    // 返回当前 node 节点偷/不偷的最大金额，[不偷，偷]
    private int[] robTree(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 后序遍历
        int[] left = robTree(node.left);
        int[] right = robTree(node.right);

        // 当前节点
        // 偷     当前节点值   不偷左边       不偷右边
        int val1 = node.val + left[0] + right[0];
        // 不偷，则可以选择偷或不偷其左右子节点，选最大值
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {val2, val1};
    }

    private class TreeNode {
        TreeNode left;
        int val;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, int val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }
    }

    private Map<TreeNode, Integer> record = new HashMap<>();

    // 记忆搜索法
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {
            return root.val;
        }

        if (record.get(root) != null) {
            return record.get(root);
        }

        // 偷根节点
        int val1 = root.val;
        if (root.left != null) val1 += rob2(root.left.left) + rob2(root.left.right);
        if (root.right != null) val1 += rob2(root.right.left) + rob2(root.right.right);

        // 不偷根节点
        int val2 = rob2(root.left) + rob2(root.right);
        int res = Math.max(val1, val2);
        record.put(root, res);
        return res;
    }
}
