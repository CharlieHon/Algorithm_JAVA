package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/12/3 9:58
 * @description: 加油站
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 起始位置
        int start = 0;
        // 从 start 到 i 累计剩余油量
        int currSum = 0;
        // 从 0 到 gas.length - 1 总计累计剩余油量。
        int totalSum = 0;

        for (int i = start; i < gas.length; i++) {
            // 从 start 到 i 的累计
            currSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (currSum < 0) {  // currSum < 0 表示，从 start 开始 到 i 这就不行
                start = i + 1;  // 更新 start ，从 i + 1开始
                currSum = 0;    // 重新统计currSum
            }
        }
        // 当总计剩余量 < 0时，一定无法转一圈
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }

    // 方法1：暴力法，从每个加油站依次尝试
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        // i 为起点
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            // index 为下一站
            int index = (i + 1) % gas.length;
            while (rest > 0 && index != i) {
                rest += gas[index] - cost[index];
                index = (index + 1) % gas.length;
            }
            // 如果以 i 为起点跑一圈，剩余油量 >= 0，返回该起始位置
            if (rest >= 0 && index == i) {
                return i;
            }
        }
        return -1;
    }

}
