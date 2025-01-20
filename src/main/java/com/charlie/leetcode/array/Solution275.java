package com.charlie.leetcode.array;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/20 19:35
 * @Description: H值数
 * h指数表示其论文至少有h篇的被引用次数大于等于h
 *
 * 🔺：如果有5篇文献引用次数>=5，那么肯定有4篇文献引用次数>=4，所以本题 **越小越符合要求**
 * 所以这里返回的是right
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // 注意：二分的是h值数，不是文献
        // 肯定有0篇文献>=0，所以可以优化略过
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 引用次数最多的mid篇文章，因此次数都>=mid
            if (citations[n - mid] >= mid) {
                // left - 1都符合条件
                left = mid + 1;
            } else {
                // right + 1都不符合条件
                right = mid - 1;
            }
        }
        // 循环结束后 right 等于 left-1，回答一定为「是」
        // 根据循环不变量，right 现在是最大的回答为「是」的数
        return right;
    }
}
