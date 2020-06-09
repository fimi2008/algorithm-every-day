package top.lionxxw.learn.algorithm.lesson.day08;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

/**
 * 二叉树的递归套路深度实践
 * 给定一棵二叉树的头节点head,返回这颗二叉树是不是平衡二叉树
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/9 19:34
 */
public class IsBalanced extends BaseClass {

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean b, int h) {
            isBalanced = b;
            height = h;
        }
    }

    public static boolean isBalanced(Node head){
        return process(head).isBalanced;
    }

    /**
     * 什么是平衡树:
     * 1.左树是平衡的
     * 2.右树是平衡的
     * 3.左树和右树的高度差不能超过1
     *
     * @param node X节点
     * @return 假设以X节点为头，假设可以向X左树和X右树要任何信息
     */
    public static Info process(Node node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced
                || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(isBalanced, height);
    }
}
