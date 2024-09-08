package com.charlie.datastructure.deque;

import java.util.Iterator;

/**
 * 基于双向链表实现
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    private static class Node<E> {
        Node<E> pre;
        E value;
        Node<E> next;

        public Node(Node<E> pre, E value, Node<E> next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }

    private int capacity;
    private int size;
    private final Node<E> sentinel = new Node<>(null, null, null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        this.sentinel.next = this.sentinel;
        this.sentinel.pre = this.sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        // 注意：双向链表添加元素需要改动4个指针
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a, e, b);
        a.next = added;
        b.pre = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> a = sentinel.pre;
        Node<E> b = sentinel;
        Node<E> added = new Node<>(a, e, b);
        a.next = added;
        b.pre = added;
        size++;
        return true;
    }

    // a removed b
    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> a = sentinel;
        Node<E> removed = sentinel.next;
        Node<E> b = removed.next;
        a.next = b;
        b.pre = a;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = sentinel.pre;
        Node<E> a = removed.pre;
        Node<E> b = sentinel;
        a.next = b;
        b.pre = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.pre.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
