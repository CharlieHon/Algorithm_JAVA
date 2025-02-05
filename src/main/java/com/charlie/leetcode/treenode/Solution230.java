package com.charlie.leetcode.treenode;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/5 11:19
 * @Description: 二叉搜索树中第K小的元素
 */
class Solution230 {
    // 对于 int 这种基础类型的参数，在函数调用的时候会【复制】一份往下传递，cnt-=1 修改的【仅仅】是当前函数中的 cnt 参数，
    // 并不会影响到其他节点的 cnt。但如果把 cnt 放在函数外，执行 cnt-=1 就会影响全局了
    private int cnt;
    public int kthSmallest(TreeNode root, int k) {
        this.cnt = k;
        return dfs(root);
    }

    private int dfs(TreeNode p) {
        if (p == null) {
            return -1;
        }
        int leftRes = dfs(p.left);
        if (leftRes != -1) {
            return leftRes;
        }
        if (--cnt == 0) {
            return p.val;
        }
        return dfs(p.right);
    }

}
