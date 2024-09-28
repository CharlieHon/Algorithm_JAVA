package com.charlie.leetcode.treenode;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>从中序与后序遍历序列构造二叉树</h3>
 * 思路：用后序遍历最后一个元素值(根节点值)切割中序遍历，然后使用中序遍历范围再次切割后序遍历，递归进行
 */
public class Solution106 {

    /* 使用map保存中序序列的数值对应位置 */
    private static Map<Integer, Integer> map;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // 值-索引位置
        }
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public static TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart == inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        if (postEnd - postStart == 1) {
            // 只有一个节点时
            return root;
        }

        // 根据根节点，划分中序数组
        int rootIndex = map.get(rootVal);
        // 左中序数组 [inStart, rootIndex)
        // 左后序数组 [postStart, postStart + rootIndex - inStart)
        root.left = helper(inorder, inStart, rootIndex, postorder, postStart, postStart + rootIndex - inStart);
        // 右中序数组 [rootIndex + 1, inEnd)
        // 右后序数组 [postStart + rootIndex - inStart, postStart + inEnd - inStart - 1)
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postStart + inEnd - inStart - 1);
        return root;
    }
}
