package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h3>二叉树的右视图</h3>
 * 右视图看到的，就是每层最后一个元素！
 */
public class Solution199 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                if (i == size - 1) {    // 该层的最后一个元素，即是右视图下的看到的元素
                    ans.add(curr.val);
                }
            }
        }
        return ans;
    }
}
