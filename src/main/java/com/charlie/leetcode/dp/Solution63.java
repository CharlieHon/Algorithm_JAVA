package com.charlie.leetcode.dp;

/**
 * @Author: charlie
 * @CreateTime: Created in 2024/12/14 12:45
 * @Description: 不同路径Ⅱ
 */
public class Solution63 {

    /**
     * 不同路径带障碍版
     * @param obstacleGrid m x n 矩阵，其中值为1的地方表示有障碍物
     * @return 返回达到右下角的路径个数
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        // 第一行：障碍物前都是1，障碍物及其后都是0
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[i] = 1;
        }

        // 以上已经处理了带障碍物的第一行
        for (int i = 1; i < m; i++) {
            // j 要从0开始，对于带障碍物的以后行每列都要进行处理
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

}
