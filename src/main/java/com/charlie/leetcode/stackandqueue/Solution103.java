package com.charlie.leetcode.stackandqueue;

import com.charlie.datastructure.binarytree.TreeNode;

import java.util.*;

/**
 * 二叉树Z字层序遍历
 */
public class Solution103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7)));
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println("lists=" + lists);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int c1 = 1;
        boolean odd = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode curr = queue.poll();
                if (odd) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                    c2++;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    c2++;
                }
            }
            c1 = c2;
            odd = !odd;
            result.add(level);
        }
        return result;
    }

}
