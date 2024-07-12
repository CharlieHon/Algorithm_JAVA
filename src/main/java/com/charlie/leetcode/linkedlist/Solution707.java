package com.charlie.leetcode.linkedlist;

import java.util.Iterator;

/**
 * <h1>设计链表</h1>
 */
public class Solution707 {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(9);
        obj.addAtTail(4);
        obj.addAtTail(6);
        obj.addAtTail(7);
        obj.addAtIndex(1, 5);
        obj.deleteAtIndex(2);

        for (Integer val : obj) {
            System.out.println(val);
        }

    }
}

class MyLinkedList implements Iterable<Integer> {

    // 节点类
    private class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private int size;   // 链表大小
    private Node dummy; // 虚拟头结点

    public MyLinkedList() {
        size = 0;
        dummy = new Node(-1, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = dummy;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        //dummy.next = new Node(val, dummy.next);
        //size++;
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        //Node p = dummy;
        //while (p.next != null) {
        //    p = p.next;
        //}
        //p.next = new Node(val, null);
        //size++;
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }

        Node pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(val, pre.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            MyLinkedList.Node p = dummy.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int val = p.val;
                p = p.next;
                return val;
            }
        };
    }
}
