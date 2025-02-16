package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/16 13:43
 * @Description: 二叉树的中序遍历
 */
class Solution94 {

    // 迭代法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 先判断当前节点 root 是否为空，不为空则一直向左遍历，遍历到的节点放入栈中，直到空节点
        // 则此时 stack 中栈顶节点即 最左边节点
        // 弹出栈顶节点，值放入 ans，然后按照同样方式遍历 栈顶节点的右子树
        while (!stack.isEmpty() || root != null) {
            // if (root != null) {
            //     stack.push(root);
            //     root = root.left;
            // } else {
            //     TreeNode tmp = stack.pop();
            //     ans.add(tmp.val);
            //     root = tmp.right;
            // }
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
