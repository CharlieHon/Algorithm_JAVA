package com.charlie.leetcode.treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h3>对称二叉树</h3>
 */
public class Solution101 {

    // 递归法
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {    // 都为null
            return true;
        }
        if (left == null || right == null) {    // 有一个为null
            return false;
        }

        if (left.val != right.val) {            // 都不为null，但是值不相等
            return false;
        }

        // 左右子节点不为null，且值相等
        // 比较对称，即左节点左侧和右节点右侧相等，左节点右侧和右节点左侧相等
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null&& root.right == null)) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            // 左左与右右比较
            q.offer(left.left);
            q.offer(right.right);

            // 左右与右左比较
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

}
