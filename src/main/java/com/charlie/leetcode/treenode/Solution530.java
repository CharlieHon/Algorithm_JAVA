package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>二叉搜索树的最小绝对差</h3>
 * 二叉树的中序遍历是一个有序数组！
 */
public class Solution530 {

    /**
     * 法1：中序遍历搜索二叉树，将值记录到数组中，在遍历数组寻找最小的相邻元素插值
     */
    private List<Integer> list = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);     // 中序遍历
        inOrder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        if (list.size() < 2) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }
        return res;
    }

    /**
     * 法2：在中序遍历的过程中进行比较，使用pre节点记录遍历的上一个节点
     */

    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);   // 左
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);    // 中
        }
        pre = root;             // 记录上一个节点
        traversal(root.right);  // 右
    }

}
