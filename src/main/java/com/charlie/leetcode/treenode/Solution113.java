package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h3>路径总和Ⅱ</h3>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径
 */
public class Solution113 {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, targetSum, result, path);
        return result;
    }

    // 前序遍历
    private static void traversal(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val); // 中
        // 遇到叶子节点
        if (root.left == root.right) {
            // 找到了和为 targetSum 的路径
            if (targetSum == root.val) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetSum，返回
        }

        if (root.left != null) {
            traversal(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);   // 回溯
        }

        if (root.right != null) {
            traversal(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);   // 回溯
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(
                                new TreeNode(7),
                                11,
                                new TreeNode(2)
                        ),
                        4,
                        null
                ),
                5,
                new TreeNode(
                        new TreeNode(13),
                        8,
                        new TreeNode(
                                new TreeNode(5),
                                4,
                                new TreeNode(1)
                        )
                )
        );
        List<List<Integer>> res = pathSum(root, 22);
        System.out.println("res=" + res);
    }
}
