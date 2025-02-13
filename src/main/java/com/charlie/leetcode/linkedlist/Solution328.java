package com.charlie.leetcode.linkedlist;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/13 13:39
 * @Description: 奇偶链表
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 */
class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;

        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }

        oddTail.next = evenHead.next;
        // 偶数节点在新链表的最后，需要将其 next 置为 null
        evenTail.next = null;
        return oddHead.next;
    }
}
