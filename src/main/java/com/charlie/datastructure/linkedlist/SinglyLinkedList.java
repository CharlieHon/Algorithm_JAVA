package com.charlie.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> { // 整体

    private Node head = null;  // 头指针

    /**
     * 节点类
     * 与外部类的成员变量没有关系，可以加 static，能加应加
     */
    private static class Node {
        int value;  // 值
        Node next;  // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /**
     * 向链表头部添加元素
     *
     * @param value 待添加值
     */
    public void addFirst(int value) {
        // 1. 链表为空
        //head = new Node(value, null);
        // 2. 链表非空，可以统一起来
        head = new Node(value, head);
    }

    /**
     * 向链表尾部添加
     *
     * @param value 待添加值
     */
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) { // 空链表
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    /**
     * 根据索引查找
     *
     * @param index 索引
     * @return 找到, 返回该索引位置节点的值
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public int get(int index) throws IllegalArgumentException {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    /**
     * 向索引位置插入
     *
     * @param index 索引
     * @param value 待插入值
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public void insert(int index, int value) throws IllegalArgumentException {

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node prev = findNode(index - 1);    // 找到上一个节点
        if (prev == null) { // 找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);

    }

    /**
     * 删除第一个
     *
     * @throws IllegalArgumentException - 如果不存在, 抛出 index 非法异常
     */
    public void removeFirst() throws IllegalArgumentException {
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    /**
     * 从索引位置删除
     *
     * @param index 索引
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public void remove(int index) throws IllegalArgumentException {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

    /**
     * 遍历链表1
     *
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表2
     *
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }

    /**
     * 当某一个内部类使用了外部类的成员变量是，就不能加 static，
     * 这里用到了外部类的head，与外部类的实例相关，就不能加 static
     */
    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

        @Override
        public boolean hasNext() {  // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() {     // 返回当前值，并指向下一个值
            int value = p.value;
            p = p.next;
            return value;
        }
    }

    /**
     * 找到指定索引位置处的节点
     *
     * @param index 索引值
     * @return 节点
     */
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;    // 没找到
    }

    /**
     * 查找链表的最后一个节点
     *
     * @return 链表的最后一个节点
     */
    private Node findLast() {
        if (head == null) { // 空链表
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) ;
        return p;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }
}


