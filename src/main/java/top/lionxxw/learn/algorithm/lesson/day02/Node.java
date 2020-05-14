package top.lionxxw.learn.algorithm.lesson.day02;

import javax.xml.ws.handler.HandlerResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单向链表
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/14 15:45
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 单向链表反转
     *
     * @param head 单向链表头节点
     * @return 反转后的链表
     */
    public static Node reverse(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 删除指定元素
     * @param head 单向链表
     * @param value 删除的值
     * @return 新的链表
     */
    public static Node removeValue(Node head, int value) {
        // 判断头部元素等于value需要删多少
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        // head来到第一个不用删的位置
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7};
        Node head = arrayToNode(arr);
        System.out.println(head);
        Node reverse = reverse(head);
        System.out.println(reverse);
        Node after = removeValue(reverse, 4);
        System.out.println(after);
    }

    /**
     * 数组生成单向链表
     *
     * @param arr 数组
     * @return 单向链表
     */
    public static Node arrayToNode(int[] arr) {
        if (arr == null) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    @Override
    public String toString() {
        Node node = this;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }
        return Arrays.toString(list.toArray());
    }
}
