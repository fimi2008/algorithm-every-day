package top.lionxxw.learn.algorithm.lesson.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表快慢指针问题
 * 1)输入链表头节点，奇数长度返回中点，偶数长度返回上中点
 * 2)输入链表头节点，奇数长度返回中点，偶数长度返回下中点
 * 3)输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
 * 4)输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/29 13:37
 */
public class LinkedListMid {

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
//        test.next.next.next.next.next.next.next.next = new Node(8);

        List<Integer> list = new ArrayList<>();
        Node item = test;
        while (item != null) {
            list.add(item.value);
            item = item.next;
        }
        System.out.println("数组:" + list);
        System.out.println("奇数长度返回中点，偶数长度返回上中点:" + midOrUpMidNode(test).value);
        System.out.println("奇数长度返回中点，偶数长度返回下中点:" + midOrDownMidNode(test).value);
        System.out.println("奇数长度返回中点前一个，偶数长度返回上中点前一个:" + midOrUpMidPreNode(test).value);
        System.out.println("奇数长度返回中点前一个，偶数长度返回下中点前一个:" + midOrDownMidPreNode(test).value);
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidNode(Node head) {
        // 0或1个节点,返回本身
        if (head == null || head.next == null) {
            return head;
        }
        // 2个节点,返回最后一个节点
        Node fast = head.next;
        Node slow = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
     * @param head
     * @return
     */
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node fast = head.next;
        Node slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
