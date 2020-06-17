package top.lionxxw.learn.algorithm.lesson.day08;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

import java.util.ArrayList;

/**
 * 给定一棵二叉树的头节点head,返回这颗二叉树中最大的二叉搜索子树的节点数
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/15 14:23
 */
public class MaxSubBSTSize extends BaseClass {
    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTSize1(head) != maxSubBSTSize(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static int maxSubBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubBSTSize;
    }

    public static Info process(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int min = x.value, max = x.value, maxSubBSTSize = 0;
        // 1,与x无关
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        boolean isAllBST = false;
        // 2.与x有关
        if (
            // 左树满足搜索二叉树的条件
                (leftInfo == null ? true : (leftInfo.isAllBST && leftInfo.max < x.value))
                        &&
                        // 右树满足搜索二叉树的条件
                        (rightInfo == null ? true : (rightInfo.isAllBST && rightInfo.min > x.value))
        ) {
            isAllBST = true;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) +
                    (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }

        return new Info(isAllBST, maxSubBSTSize, min, max);

    }

    public static class Info {
        private boolean isAllBST;
        private int maxSubBSTSize;
        private int min;
        private int max;

        public Info(boolean isAllBST, int maxSubBSTSize, int min, int max) {
            this.isAllBST = isAllBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static int maxSubBSTSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }
}
