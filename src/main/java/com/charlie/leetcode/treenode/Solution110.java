package com.charlie.leetcode.treenode;

/**
 * <h3>平衡二叉树</h3>
 * 本题中，平衡二叉树定义为：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1
 */
public class Solution110 {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 本题中高度的定义，即当前节点到叶子节点的最大深度
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * 本方法返回当前节点高度，-1表示非平衡二叉树
     * @param node 当前节点
     * @return -1 表示当前节点不是平衡二叉树；0或正数表示当前节点的高度
     */
    private static int getHeight2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 使用-1标记以当前节点为根节点的子二叉树不是平衡二叉树，从而达到剪枝的效果
        int leftHeight = getHeight2(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight2(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 如果左右子树高度差小于2，则当前节点高度为Math.max(left, right) + 1，否则当前节点不是平衡二叉树
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
