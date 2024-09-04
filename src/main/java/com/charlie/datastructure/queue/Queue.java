package com.charlie.datastructure.queue;

/**
 * 自定义队列接口
 * @param <E>
 */
public interface Queue<E> {

    /**
     * 向队列尾插入值
     * @param value - 待插入值
     * @return 插入成果返回 true，失败返回 false
     */
    boolean offer(E value);

    /**
     * 从队列头获取值，并移除
     * @return 如果队列非空，返回队头值，否则返回 null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return 如果队列非空返回头值，否则返回null
     */
    E peek();

    /**
     * 检查队列是否为空
     * @return 空返回 true，否则返回false
     */
    boolean isEmpty();

    /**
     * 检查队列是否已满
     * @return 满返回true，否则返回false
     */
    boolean isFull();
}
