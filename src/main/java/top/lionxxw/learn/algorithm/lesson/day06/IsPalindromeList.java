package top.lionxxw.learn.algorithm.lesson.day06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个单链表的头节点head,请判断该链表是否为回文结构。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/29 14:28
 */
public class IsPalindromeList {

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println("是否为回文:" + isPalindrome1(head));
        System.out.println("是否为回文:" + isPalindrome2(head));
        System.out.println("是否为回文:" + isPalindrome3(head));
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 基于栈实现回判断
     * 空间复杂度O(N)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        Deque<Node> stack = new ArrayDeque<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 基于栈实现回判断
     * 空间复杂度O(N/2)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Deque<Node> stack = new ArrayDeque<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
        }
        // 得到中点节点
        n2 = n1.next;
        n1.next = null;
        Node temp;
        // 开始逆序
        while (n2 != null) {
            // 将下一个节点缓存下来
            temp = n2.next;
            // 将节点的下一节点指向上一节点
            n2.next = n1;
            // 将新的节点替换为上一节点
            n1 = n2;
            // 遍历原节点的下一节点
            n2 = temp;
        }
        // 用temp指向新的逆序节点为n1
        temp = n1;
        // 用n2指向原链表左侧部分
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 还原之前逆序的链表
        n1 = temp.next;
        temp.next = null;
        while (n1 != null) {
            // 将下一个节点缓存下来
            n2 = n1.next;
            // 将节点的下一节点指向上一节点
            n1.next = temp;
            // 将新的节点替换为上一节点
            temp = n1;
            // 遍历原节点的下一节点
            n1 = n2;
        }
        return res;
    }
}
