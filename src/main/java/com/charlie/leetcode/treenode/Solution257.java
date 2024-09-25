package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>二叉树的所有路径</h3>
 */
public class Solution257 {

    // 回溯
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    private static void traversal(TreeNode node, List<Integer> path, List<String> result) {
        // 前序遍历，中
        path.add(node.val);

        // 遇到叶子节点
        if (node.left == null && node.right == null) {
            // 输出路径
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1)); // 最后一个节点
            result.add(sb.toString());          // 收集一个路径
            return;
        }

        // 递归和回溯是同时进行的，所以要放在同一个花括号里
        if (node.left != null) {    // 左
            traversal(node.left, path, result);
            path.remove(path.size() - 1);   // 回溯
        }

        if (node.right != null) {   // 右
            traversal(node.right, path, result);
            path.remove(path.size() - 1);   // 回溯
        }
    }


    // 递归
    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }

        if (root.left != null) {
            for (String path : binaryTreePaths2(root.left)) {
                result.add(root.val + "->" + path);
            }
        }

        if (root.right != null) {
            for (String path : binaryTreePaths2(root.right)) {
                result.add(root.val + "->" + path);
            }
        }
        return result;
    }

    // 回溯法二
    public static List<String> binaryTreePaths3(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(new StringBuilder(path).append(node.val).toString());
            return;
        }
        String temp = new StringBuilder(path).append(node.val).append("->").toString();
        dfs(node.left, temp, result);
        dfs(node.right, temp, result);
    }

}
