package com.charlie.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>二叉搜索树中的众数</h3>
 */
public class Solution501 {

    int maxCount = 0;   // 统计最大频率
    int count = 0;      // 统计当前元素值频率
    TreeNode pre = null;    // 上一个节点
    List<Integer> ans;

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        // 前一个元素为null，说明此时是第一个元素。或者相邻元素不相等，则更新统计
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }

        if (count == maxCount) {    // 如果和最大值相同，放入ans中
            ans.add(root.val);
        } else if (count > maxCount) {  // 统计数大于最大值
            maxCount = count;   // 更新最大频率
            ans.clear();        // 清空原来统计！！！
            ans.add(root.val);  // 放入结果
        }

        pre = root; // 更新pre节点

        inOrder(root.right);

    }

    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        ans = new ArrayList<>();

        inOrder(root);

        //int[] res = new int[ans.size()];
        //for (int i = 0; i < res.length; i++) {
        //    res[i] = ans.get(i);
        //}
        //return res;
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
