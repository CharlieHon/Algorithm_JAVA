package com.charlie.leetcode.linkedlist;

/**
 * @Author: charlie
 * @CreateTime: Created in 2025/2/13 13:32
 * @Description: 随机链表的复制
 */
class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 复制每个节点，并插入到原节点的后面
        for (Node curr = head; curr != null; curr = curr.next.next) {
            curr.next = new Node(curr.val, curr.next);
        }

        // 遍历交错链表中的原节点，更新 新节点的random指针
        for (Node curr = head; curr != null; curr = curr.next.next) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
        }


        // 把交错链表分离成两个链表
        Node newHead = head.next;
        Node curr = head;
        for (; curr.next.next != null; curr = curr.next) {
            Node copy = curr.next;
            curr.next = copy.next;
            copy.next = copy.next.next;
        }
        // 交错节点有偶数个节点，将原链表的最后一个节点next置为null
        curr.next = null;
        return newHead;
    }
}
