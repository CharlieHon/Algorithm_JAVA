package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/16 10:47
 * @Description: 不同的二叉搜索树：给定一个整数n，求以1,2,...,n为节点组成的二叉搜索树有多少种？
 * 注意：本题只需要求解个数，不用列出所有的情况！
 */
public class Solution96 {
    public int numTrees(int n) {
        // 1. 定义：dp[i]即以 1,...,i 为节点组成的二叉搜索树个数 or 节点数为i的二叉搜索树个数
        int[] dp = new int[n + 1];
        // 3. 初始化：dp[0]即节点数为0的二叉搜索树个数，应该为1
        dp[0] = 1;

        // 2. 递推关系式：dp[i] = 以j为节点 左侧二叉搜索数个数 * 右侧二叉搜索树个数
        //                      j = 1,2,...,i
        // 4. 遍历顺序：从前往后
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 比如：当i=3时
                //      j = 1 以1为根节点， 左二叉搜索树个数为dp[0] 右二叉搜索数个数为dp[2]
                //      j = 2 以2为根节点， 左二叉搜索树个数为dp[1] 右二叉搜索数个数为dp[1]
                //      ...
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
