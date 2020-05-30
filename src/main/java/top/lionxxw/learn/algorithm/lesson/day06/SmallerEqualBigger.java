package top.lionxxw.learn.algorithm.lesson.day06;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 1)把链表放入数组里，在数组上做partition (笔试用)
 * 2)分成小、中、大三部分，再把各个部分之间串起来(面试用)
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/29 17:25
 */
public class SmallerEqualBigger extends BaseClass {

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition2(Node head, int pivot) {
        Node lh = null, lt = null, ch = null, ct = null, rh = null, rt = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (lh == null) {
                    lh = head;
                    lt = head;
                } else {
                    lt.next = head;
                    lt = head;
                }
            } else if (head.value > pivot) {
                if (rh == null) {
                    rh = head;
                    rt = head;
                } else {
                    rt.next = head;
                    rt = head;
                }
            } else {
                if (ch == null) {
                    ch = head;
                    ct = head;
                } else {
                    ct.next = head;
                    ct = head;
                }
            }
            head = next;
        }
        if (lt != null) {
            lt.next = ch;
            ct = ct == null ? lt : ct;
        }
        if (ct != null) {
            ct.next = rh;
        }
        return lh != null? lh: ch != null ? ch: rh;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
