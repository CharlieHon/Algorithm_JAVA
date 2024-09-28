package com.charlie.leetcode.treenode;

/**
 * <h3>从前序与中序遍历序列构造二叉树</h3>
 */
public class Solution105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        if (preorder.length == 1) {
            return root;
        }

        // 根据根节点，切割中序数组
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }

        // 根据根节点位置，切割中序数组，得到 左中序数组和右中序数组
        int[] leftInorder = new int[idx];
        System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
        int[] rightInorder = new int[inorder.length - idx - 1];
        System.arraycopy(inorder, idx + 1, rightInorder, 0, rightInorder.length);

        // 切割前序数组，为 左前序数组和右前序数组
        int[] leftPreorder = new int[leftInorder.length];
        System.arraycopy(preorder, 1, leftPreorder, 0, leftPreorder.length);
        int[] rightPreorder = new int[rightInorder.length];
        System.arraycopy(preorder, leftPreorder.length + 1, rightPreorder, 0, rightPreorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

}
