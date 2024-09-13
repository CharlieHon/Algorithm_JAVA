package com.charlie.algorithm.recursion_multi;

import java.util.LinkedList;

/**
 * 递归汉诺塔
 */
public class E02HanoiTower {

    private static final LinkedList<Integer> a = new LinkedList<>();
    private static final LinkedList<Integer> b = new LinkedList<>();
    private static final LinkedList<Integer> c = new LinkedList<>();

    private static void init(int n) {
        for (int i = 1; i <= n; i++) {
            a.addFirst(i);
        }
    }

    /**
     * <h3>移动圆盘</h3>
     *
     * @param n 圆盘个数
     * @param a 由
     * @param b 借
     * @param c 至
     */
    public static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 1) {
            c.addLast(a.removeLast());
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        move(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        init(5);
        print();    // [3, 2, 1], [], []

        //b.addLast(a.removeFirst());
        //print();    // [2, 1], [3], []

        move(5, a, b, c);
        print();
    }

    private static void print() {
        System.out.println("-------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
