package com.charlie.leetcode.treenode;

/**
 * <h3>完全二叉树的节点数</h3>
 * 完全二叉树是指，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * <lo>
 *     <li>
 *         判断其子数是不是满二叉树，如果是则利用公式计算这个子数(满二叉树)的节点数量
 *     </li>
 *     <li>
 *         如果不是，则继续递归
 *     </li>
 * </lo>
 */
public class Solution222 {

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftDepth = 0;
        int rightDepth = 0;

        // 求左子树深度
        while (left != null) {
            leftDepth++;
            left = left.left;
        }

        // 求右子树深度
        while (right != null) {
            rightDepth++;
            right = right.right;
        }

        if (leftDepth == rightDepth) {
            // 满二叉树节点计算公式
            return (2 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
