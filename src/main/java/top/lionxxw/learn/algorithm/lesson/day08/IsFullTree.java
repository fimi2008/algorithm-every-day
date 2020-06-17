package top.lionxxw.learn.algorithm.lesson.day08;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

/**
 * 给定一棵二叉树的头节点head,返回这颗二叉树是不是满二叉树
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/15 17:23
 */
public class IsFullTree extends BaseClass {

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isFull1(head) != isFull2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static boolean isFull1(Node head) {
        if (head == null) {
            return true;
        }
        int height = h(head);
        int nodes = n(head);
        return (1 << height) - 1 == nodes;
    }

    public static int h(Node head) {
        if (head == null) {
            return 0;
        }
        return Math.max(h(head.left), h(head.right)) + 1;
    }

    public static int n(Node head) {
        if (head == null) {
            return 0;
        }
        return n(head.left) + n(head.right) + 1;
    }

    // 满二叉树的条件: 2^height-1=nodes height:二叉树的高度,nodes:二叉树的节点数
    public static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        Info all = process(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    public static class Info {
        /**
         * 二叉树的高度
         */
        public int height;
        /**
         * 二叉树的个人数
         */
        private int nodes;

        public Info(int l, int n) {
            this.height = l;
            this.nodes = n;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int l = Math.max(leftInfo.height, rightInfo.height) + 1;
        int n = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(l, n);
    }
}
