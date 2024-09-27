package com.charlie.leetcode.treenode;

/**
 * <h3>路径总和</h3>
 */
public class Solution112 {

    // 判断二叉树中是否存在 根节点到叶子节点耳多路径，是否存在路径和==targetSum的路径
    public static boolean getPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == root.right && root.val == targetSum) {
            return true;    // 当前节点为叶子节点，且路径和等于目标值
        }
        return getPathSum(root.left, targetSum - root.val) || getPathSum(root.right, targetSum - root.val);
    }

    // 因为只需要判断是否存在一条路径和与targetSum是否相等，所以不需要遍历整合二叉树
    // 所以，使用递归时，需要有返回值进行剪枝，提前停止遍历
    public static boolean getPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum - root.val);
    }

    private static boolean traversal(TreeNode curr, int count) {
        if (curr.left == curr.right && count == 0) {
            return true;
        }
        if (curr.left == curr.right) {
            return false;
        }

        if (curr.left != null) {
            if (traversal(curr.left, count - curr.left.val)) {
                return true;
            }
        }

        if (curr.right != null) {
            if (traversal(curr.right, count - curr.right.val)) {
                return true;
            }
        }
        return false;
    }
}
