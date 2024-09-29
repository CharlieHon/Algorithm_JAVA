package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>验证二叉搜索树</h3>
 */
public class Solution98 {

    TreeNode max = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= max.val) {
            return false;
        }

        max = root;
        return isValidBST(root.right);
    }


    List<Integer> res = new ArrayList<>();
    // 迭代法：二叉搜索树的中序遍历是一个有序数组，根据此进行判断
    public boolean isValidBST2(TreeNode root) {
        inOrder(root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

}
