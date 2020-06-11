package top.lionxxw.learn.algorithm.lesson.day08;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵二叉树的头节点head,返回这颗二叉树中最大的二叉搜索子树的头节点
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/10 16:00
 */
public class MaxSubBSTHead extends BaseClass {

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        for (int i = 0; i < 100; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            printTree(head);
            Node node = maxSubBSTHead(head);
            System.out.println("最大的二叉搜索子树的头节点");
            printTree(node);
            System.out.println("======================");
        }


    }

    public static class Info {
        public Node maxSubBSTHead;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(Node h, int size, int mi, int ma) {
            maxSubBSTHead = h;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

    /**
     * 二叉搜索树的成立条件：
     * 1.若任意结点的左子树不空，则左子树上所有结点的值均不大于它的根结点的值。
     * 2.若任意结点的右子树不空，则右子树上所有结点的值均不小于它的根结点的值。
     * 3.任意结点的左、右子树也分别为二叉搜索树。
     */
    public static Node maxSubBSTHead(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    public static Info process(Node node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int max = node.value;
        int min = node.value;
        Node maxNode = null;
        int maxSize = 0;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            maxNode = leftInfo.maxSubBSTHead;
            maxSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            if (rightInfo.maxSubBSTSize > maxSize) {
                maxNode = rightInfo.maxSubBSTHead;
                maxSize = rightInfo.maxSubBSTSize;
            }
        }
        // 左子树不为空,并且左子树的最大值小于根节点,当前左子树的最大节点是当前的节点的左节点
        if ((leftInfo == null ? true : (leftInfo.max < node.value && leftInfo.maxSubBSTHead == node.left))
                // 右子树不为空,并且右子树的最小值大于根节点,当前右子树的最大节点是当前的节点的右节点
                && (rightInfo == null ? true : (rightInfo.min > node.value && rightInfo.maxSubBSTHead == node.right))) {
            maxNode = node;
            maxSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }

        return new Info(maxNode, maxSize, min, max);
    }
}
