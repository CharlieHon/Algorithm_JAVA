package com.charlie.leetcode.linkedlist;

/**
 * <h1>链表相交</h1>
 */
public class Solution160 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * <h3>尾部对齐，然后同时移动指针找相同节点处</h3>
     * @param headA 链表A头结点
     * @param headB 链表B头结点
     * @return 链表相交处节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode h1 = headA, h2 = headB;

        while (h1 != null) {
            h1 = h1.next;
            sizeA++;
        }
        h1 = headA;

        while (h2 != null) {
            h2 = h2.next;
            sizeB++;
        }
        h2 = headB;

        int gap = (sizeA >= sizeB) ? (sizeA - sizeB) : (sizeB - sizeA);
        if (sizeA >= sizeB) {
            for (int i = 0; i < gap; i++) {
                h1 = h1.next;
            }
            while (h1 != null) {
                if (h1 == h2) {
                    return h1;
                } else {
                    h1 = h1.next;
                    h2 = h2.next;
                }
            }
        } else {
            return getIntersectionNode(headB, headA);
        }

        return null;
    }

    /**
     * <h3>合并链表移动法</h3>
     * @param headA 链表A头结点
     * @param headB 链表B头结点
     * @return 链表相交处节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }

        return p1;
    }
}
