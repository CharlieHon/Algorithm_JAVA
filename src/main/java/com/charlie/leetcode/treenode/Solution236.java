package com.charlie.leetcode.treenode;

/**
 * <h3>二叉树的最近公共祖先</h3>
 */
public class Solution236 {

    // 使用后序遍历，从下到上遍历二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为null，或者根节点是其中一个节点，则root就是最近公共祖先
        if (root == null || root == q || root == p) {
            return root;
        }

        // 先将 lowestCommonAncestor 理解为纯粹的二叉树后序遍历需要节点的函数，然后再根据返回值，判断公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        return left;
    }

}
