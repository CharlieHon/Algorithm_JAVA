package com.charlie.leetcode.linkedlist;
/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/10 23:30
 * @Description: 排序链表
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = findMiddle(head);
        // 分治
        head = sortList(head);
        head2 = sortList(head2);
        // 合并
        return mergeTwoLists(head, head2);
    }

    // Solution876. 链表的中间节点（快慢指针）
    private ListNode findMiddle(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // pre记录slow的前一个节点
            pre = slow;
            slow = slow.next;
        }
        // 在slow前断开链表
        pre.next = null;
        return slow;
    }

    // Solution21. 合并两个有序链表（双指针）
    private ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }

        pre.next = p1 != null ? p1 : p2;

        return dummy.next;
    }
}
