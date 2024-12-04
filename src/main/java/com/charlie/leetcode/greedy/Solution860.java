package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/12/4 10:10
 * @description: 柠檬水找零
 */
public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        if (n == 1) {
            return bills[0] == 5;
        }

        int five = 0;   // 5元零钱个数
        int ten = 0;    // 10元零钱个数

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }

            // 注意这里：是在每次找零后进行判断，而非在每个分支上判断！
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }

}
