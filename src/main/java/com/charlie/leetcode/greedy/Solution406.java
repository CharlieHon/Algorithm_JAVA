package com.charlie.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: charlie
 * @date: Created in 2024/12/5 10:30
 * @description: 根据身高重建队列
 *
 * 数组 people 表示队列中人的属性。people[i] = [hi, ki] 表示第 i 个人的身高为 hi，前面 正好 有 ki 个身高 >= hi 的人
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 */
public class Solution406 {

    public int[][] reconstructQueue(int[][] people) {

        // 根据身高进行排序：身高从大到小，相同身高k从小到大
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[people.length][]);
    }

}
