package com.charlie.leetcode.treenode;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>二叉树的递归遍历</h1>
 * <lo>
 *     <li>
 *          144. 二叉树的前序遍历
 *     </li>
 *     <li>
 *         145. 二叉树的后序遍历
 *     </li>
 *     <li>
 *         94. 二叉树的中序遍历
 *     </li>
 * </lo>
 */
public class Traversal {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(
                new TreeNode(
                        new TreeNode(1),
                        4,
                        new TreeNode(2)
                ),
                5,
                new TreeNode(
                        new TreeNode(7),
                        6,
                        new TreeNode(8)
                )
        );

        // 前序遍历
        List<Integer> list = new LinkedList<>();
        traversal(node, list);
        System.out.println("list=" + list);
    }

    // 二叉树的前序遍历
    public static void traversal(TreeNode curr, List<Integer> list) {
        if (curr == null) {
            return;
        }
        list.add(curr.val); // 嘛序指的是中间节点，也就是左右的父节点遍历的顺序
        traversal(curr.left, list);
        traversal(curr.right, list);
    }

    private void test1() {

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, int val, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
