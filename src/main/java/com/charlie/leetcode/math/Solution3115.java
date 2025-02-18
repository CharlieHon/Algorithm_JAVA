package com.charlie.leetcode.math;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/18 13:21
 * @Description: 质数的最大距离
 * 1 <= nums[i] <= 100
 */
public class Solution3115 {

    public int maximumPrimeDifference(int[] nums) {
        int i = 0;
        while (!isPrime(nums[i])) {
            i++;
        }

        int j = nums.length - 1;
        while (!isPrime(nums[j])) {
            j--;
        }
        return j - i;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return x >= 2;
    }

    // 筛质数
    private static final int MAX = 101;
    private static final boolean[] NOT_PRIME = new boolean[MAX];    // NOT_PRIME[i] 表示 i 是否为质数

    static {
        // 1 不是质数
        NOT_PRIME[1] = true;
        // 遍历 sqrt(100) = 10 以内的质数 2,3,5,7 标记其倍数为合数
        for (int i = 2; i * i < MAX; i++) {
            if (NOT_PRIME[i]) continue;
            // 标记i的倍数时，只需从 j = i * i 开始，因为小于 i * i 的合数已经被 < i 的质数标记过了
            for (int j = i * i; j < MAX; j += i) {
                NOT_PRIME[j] = true;    // j 是质数 i 的倍数
            }
        }
    }

    public int maximumPrimeDifference2(int[] nums) {
        int i = 0;
        while (NOT_PRIME[nums[i]]) {
            i++;
        }
        int j = nums.length - 1;
        while (NOT_PRIME[nums[j]]) {
            j--;
        }
        return j - i;
    }
}
