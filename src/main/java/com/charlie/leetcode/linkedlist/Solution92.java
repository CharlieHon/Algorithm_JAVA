package com.charlie.leetcode.linkedlist;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/1/22 20:50
 * @Description: 反转链表Ⅱ
 * 反转链表中 [left, right] 范围内的节点
 */
public class Solution92 {

    // 注意：当 left = 1 时，前一个元素为 null，需要特殊处理
    // 反转 [2, 4] 范围内节点
    // dummyNode -> n1 -> n2 -> n3 -> n4 -> n5 -> n6 -> null
    //              p0                pre   curr
    // return dummyNode.next;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 哨兵节点
        ListNode dummyNode = new ListNode(-1, head);
        // left - 1 处节点
        ListNode p0 = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        // 反转链表
        ListNode pre = p0, curr = p0.next;
        // 反转 [left, right] 范围内的节点，即需要反转 right - left + 1 个节点
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 反转结束后，pre指向right处节点，curr指向right + 1处节点
        p0.next.next = curr;
        p0.next = pre;
        return dummyNode.next;
    }

}
