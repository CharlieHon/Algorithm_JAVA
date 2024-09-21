package com.charlie.leetcode.treenode;

import java.util.*;

/**
 * <h3>二叉树的层序遍历Ⅱ</h3>
 */
public class Solution107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            while (size > 0) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                size--;
            }
            result.add(level);
        }
        Collections.reverse(result);
        return result;
    }

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
    }

}
