package com.charlie.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {

    private int size = 0;   // 逻辑大小
    private int capacity = 8;   // 容量
    private int[] array = {};

    /**
     * 向最后位置 [size] 添加元素
     *
     * @param element
     */
    public void addLast(int element) {
        //array[size] = element;
        //size++;
        add(size, element);
    }

    /**
     * 向 [0, size] 位置添加元素
     *
     * @param index   索引位置
     * @param element 待添加元素
     */
    public void add(int index, int element) {
        checkAngGrow();

        // 添加逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAngGrow() {
        // 容量检测
        if (size == 0) {    // 懒惰初始化
            array = new int[capacity];
        } else if (size == capacity) {
            // 进行扩容 1.5 倍
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * 查询元素
     *
     * @param index 索引位置, 在 [0..size) 区间内
     * @return 该索引位置的元素
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * 从 [0 .. size) 范围删除元素
     *
     * @param index 索引位置
     * @return 被删除元素
     */
    public int remove(int index) {  // [0, ..., size)
        int removed = array[index];
        if (index < size - 1) { // 因为当index=size-1，不需要移动元素
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    /**
     * 遍历方法1
     *
     * @param consumer 遍历要执行的操作, 入参: 每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            // System.out.println(array[i]);
            // 提供 array[i]
            // 返回 void
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方式2-迭代器遍历
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {  // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    /**
     * 遍历方式3-stream遍历
     *
     * @return stream流
     */
    public IntStream stream() {
        // 只传入数组中的有效部分
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
