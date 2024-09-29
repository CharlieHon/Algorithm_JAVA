package com.charlie.leetcode.treenode;

/**
 * <h3>二叉搜索树中的搜索</h3>
 * <lo>
 *     二叉搜索树是一个有序树
 *     <li>
 *         若它的左子数不空，则左子数上所有节点的值均小于它的根节点的值
 *     </li>
 *     <li>
 *         若它的右子数不空，则右子树上所有节点的值均大于它的根节点的值
 *     </li>
 *     <li>
 *         它的左、右子数也分别为二叉搜索树
 *     </li>
 * </lo>
 */
public class Solution700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode res = null;
        if (root.val < val) {
            res = searchBST(root.right, val);
        }

        if (root.val > val) {
            res = searchBST(root.left, val);
        }

        return res;
    }

}
