package com.charlie.datastructure.deque;

import java.util.Iterator;

/**
 * 基于循环数组实现
 * <ul>
 *     <li>tail停下来的位置不存储，会浪费一个位置</li>
 * </ul>
 * @param <E> 队列中元素类型
 */
public class ArrayDeque1<E> implements Deque<E>, Iterable<E> {

    private final E[] array;
    private int head;
    private int tail;

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        array = (E[]) new Object[capacity+1];
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        array[head] = null; // help gc
        head = inc(head, array.length);
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = dec(tail, array.length);
        E e = array[tail];
        array[tail] = null; // help gc
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {   // 分两种情况
        if (head < tail) {
            return tail - head == array.length - 1;
        } else if (head > tail) {
            return head - tail == 1;
        } else {
            return false;
        }
    }

    // 更改索引值，并使其在正常范围内
    private static int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    // 更改索引值，并使其在正常范围内
    private static int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = inc(p, array.length);
                return value;
            }
        };
    }
}
