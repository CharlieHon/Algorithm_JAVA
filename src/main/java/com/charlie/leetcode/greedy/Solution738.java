package com.charlie.leetcode.greedy;

/**
 * @author: charlie
 * @date: Created in 2024/12/9 10:55
 * @description: 单调递增的数字
 * 由于要求各位数字单调递增，那么这些数字必然形如 a0a1a2...an(1<=a0<=a1<=a2<=...<=an<=9)
 * 显然有：a0 * 1111(n-1个) + (a1 - a0) * 111(n个) + ... + (an - an-1) * 1 == a0a1a2...an
 * 即若干个形如 11...1 的数字相加所得。因为 n < 10^9 ，所以可以从 1_1111_1111 开始依次累加，如果继续累加超过n，
 * 则去掉一个 1 继续循环，总累加次数不超过 9 次
 */
public class Solution738 {

    public int monotoneIncreasingDigits(int n) {
        int ones = 1_1111_1111;
        int res = 0;

        for (int i = 0; i < 9; i++) {
            while (n < res + ones) {
                ones /= 10;
            }
            res += ones;
        }
        return res;
    }

}
