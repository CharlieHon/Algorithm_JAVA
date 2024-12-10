package com.charlie.leetcode.greedy;

/**
 * <h3>监控二叉树</h3>
 * 叶子节点的三种状态：
 * 1. 没被监控覆盖：0
 * 2. 本节点有摄像头：1
 * 3. 被监控覆盖：2
 * <p>对于空节点，应该视为状态2</p>
 */
public class Solution968 {

    private int result = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return result;
    }

    private int traversal(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        if (left == 2 && right == 2) {
            // 左右节点都 已覆盖，那么本节点的状态是 无覆盖(0)，没有摄像头
            // (2, 2)
            return 0;
        } else if (left == 0 || right == 0) {
            // 左右节点都是 无覆盖，本节点需要放一个摄像头(1)
            // (0, 0), (0, 1), (1, 0), (0, 2), (2, 0)
            result++;
            return 1;
        } else if (left == 1 || right == 1) {
            // 左右节点有一个 放摄像头(1)，那么本节点 已覆盖（2）
            // (1, 1), (1, 2), (2, 1)
            return 2;
        } else {
            // 不会到达这里
            return -1;
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
