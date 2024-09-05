package com.charlie.datastructure.stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E>{

    private final E[] array;
    private int top;    // 栈顶指针

    /*
        底           顶
        0   1   2   3
        a   b   c   d
                        top
     */
    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top] = value;
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = array[top-1];
        top--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E value = array[top-1];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int p = top;

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
