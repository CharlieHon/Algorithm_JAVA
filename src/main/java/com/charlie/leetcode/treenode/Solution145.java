package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/16 11:02
 * @Description: 二叉树的后序遍历
 */
class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 当这里能确定 root.left 都已经 为空/遍历过
            root = stack.pop();
            if (root.right != null && root.right != pre) {
                // 如果当前节点 root 右侧还有节点并且没有访问过，则需要把 root 重新入栈（因为还不能加到 ans 中
                stack.push(root);
                // 然后以同样方式开始从 root.right 遍历
                root = root.right;
            } else {
                // 如果当前节点 root 右侧没有节点或者已经访问过，则把当前节点 root 加入 ans 中，并把 root 重新置为 null
                ans.add(root.val);
                pre  = root;
                root = null;
            }
        }
        return ans;
    }

    // 思路一：前序遍历（中右左）+翻转链表
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

}
