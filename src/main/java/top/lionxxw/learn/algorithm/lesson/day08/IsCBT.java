package top.lionxxw.learn.algorithm.lesson.day08;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一棵二叉树的头节点head,返回这颗二叉树中是不是完全二叉树
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/16 22:53
 */
public class IsCBT extends BaseClass {

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                printTree(head);
            }
        }
        System.out.println("finish!");
    }

    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        Node cur;
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node left;
        Node right;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            left = cur.left;
            right = cur.right;
            // 任何节点,有右子树,但是没有左子树,则必然不是完全二叉树
            if (left == null && right != null) {
                return false;
            }
            // 一旦遇到左,右子树不全有的情况,则后序节点都必须是叶节点,即后面节点都不能有子节点
            if (leaf && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            // 一旦遇到左,右子树不全有的情况
            if (right == null || left == null) {
                leaf = true;
            }
        }

        return true;
    }

    public static boolean isCBT2(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isCBT;
    }


    private static Info process(Node x) {
        if (x == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        boolean isFull = false;
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isFull = true;
        }
        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else {
            if (leftInfo.isCBT && rightInfo.isCBT) {
                if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
                    isCBT = true;
                }
                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
                    isCBT = true;
                }
                if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height){
                    isCBT = true;
                }
            }
        }
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(isFull, isCBT, height);
    }

    public static class Info {
        // 是否是满二叉树
        public boolean isFull;
        // 是否是完全二叉树
        public boolean isCBT;
        // 二叉树高度
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
