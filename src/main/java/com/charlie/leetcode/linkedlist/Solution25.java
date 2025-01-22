package com.charlie.leetcode.linkedlist;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/22 21:31
 * @Description: K个一组翻转链表
 */
class Solution25 {
    // 不足k个的剩余节点不需要反转，因此需要统计节点个数
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode node = head; node != null; node = node.next) {
            n++;
        }

        ListNode dummyNode = new ListNode(-1, head);
        ListNode p0 = dummyNode;
        ListNode pre = null;
        ListNode curr = p0.next;
        while (k <= n) {
            n -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            ListNode nextP0 = p0.next;
            p0.next.next = curr;
            p0.next = pre;
            p0 = nextP0;
        }
        return dummyNode.next;
    }

}
