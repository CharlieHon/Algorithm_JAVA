package com.charlie.leetcode.treenode;

/**
 * <h3>最大二叉树</h3>
 */
public class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 通过区间划分数组，而非重新创建新数组
        return func(nums, 0, nums.length);
    }

    // 构造nums在 [start, end) 区间的最大二叉树
    private TreeNode func(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int rootIndex = start;
        int rootVal = nums[rootIndex];

        // [start, end)区间最大值及索引
        for (int i = start + 1; i < end; i++) {
            if (rootVal < nums[i]) {
                rootVal = nums[i];
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = func(nums, start, rootIndex);
        root.right = func(nums, rootIndex + 1, end);
        return root;
    }

}
