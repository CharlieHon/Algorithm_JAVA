package com.charlie.leetcode.linkedlist;

public class Solution142 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * <h3>快慢指针法</h3>
     * 如果链表中存在环，则快慢指针一定在环内相遇。</p>
     * 从相遇处到入环节点的距离与从头结点到入环的距离相等，从这两个几点开始同时移动指针即可找到链表入环处
     * @param head 头结点
     * @return 如果链表中存在环，则返回入环节点；没有则返回null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

}
