package com.charlie.leetcode.stackandqueue;

import com.charlie.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h1>二叉树的层序遍历</h1>
 */
public class Solution102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7)));
        //LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        //queue.offer(root);
        //
        //while (!queue.isEmpty()) {
        //    TreeNode curr = queue.poll();
        //    System.out.print(curr + " ");
        //    if (curr.left != null) {
        //        queue.offer(curr.left);
        //    }
        //    if (curr.right != null) {
        //        queue.offer(curr.right);
        //    }
        //}

        List<List<Integer>> lists = levelOrder(root);
        System.out.println("lists=" + lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点个数
        while (!queue.isEmpty()) {
            int c2 = 0; // 下一层的节点树
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < c1; i++) {  // 遍历当前层节点
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    c2++;
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    c2++;
                    queue.offer(curr.right);
                }
            }
            c1 = c2;
            result.add(level);
        }
        return result;
    }

}
