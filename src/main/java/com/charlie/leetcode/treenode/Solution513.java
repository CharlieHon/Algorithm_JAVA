package com.charlie.leetcode.treenode;

/**
 * <h3>找树左下角的值</h3>
 */
public class Solution513 {

    private static int DEEP = -1;
    private static int value;

    public static int findBottomLeftValue(TreeNode root) {
        value = root.val;
        traversal(root, 0);
        return value;
    }

    private static void traversal(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (node.left == node.right) {
            if (deep > DEEP) {
                value = node.val;
                DEEP = deep;
            }
        }
        if (node.left != null) {
            traversal(node.left, deep + 1);
        }
        if (node.right != null) {
            traversal(node.right, deep + 1);
        }
    }

}
