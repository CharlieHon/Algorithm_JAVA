package com.charlie.leetcode.treenode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h3>在每个树行中找最大值</h3>
 */
public class Solution515 {

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int largestVal = q.peek().val;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                if (largestVal < curr.val) {
                    largestVal = curr.val;
                }
                // 添加元素
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            result.add(largestVal);
        }
        return result;
    }

}
