package com.charlie.leetcode.treenode;

import java.util.Stack;

/**
 * <h3>左叶子之和</h3>
 */
public class Solution404 {

    // 递归求左叶子节点之和
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == root.right) {
            return 0;
        }

        int sum = 0;
        if (root.left != null && root.left.left == root.left.right) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null || root.left == root.right) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int result = 0;
        while (!s.isEmpty()) {
            int size = s.size();
            while (size-- > 0) {
                TreeNode curr = s.pop();
                if (curr.left != null && curr.left.left == curr.left.right) {
                    result += curr.left.val;
                }
                if (curr.left != null) {
                    s.push(curr.left);
                }
                if (curr.right != null) {
                    s.push(curr.right);
                }
            }
        }
        return result;
    }

}
