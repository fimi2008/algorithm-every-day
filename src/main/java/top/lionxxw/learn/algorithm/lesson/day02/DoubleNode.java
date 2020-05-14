package top.lionxxw.learn.algorithm.lesson.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双向链表
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/14 15:49
 */
public class DoubleNode {
    public int value;
    private DoubleNode next;
    private DoubleNode pre;

    public DoubleNode(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7};
        DoubleNode head = arrayToDoubleNode(arr);
        System.out.println(head);
        DoubleNode reverse = reverse(head);
        System.out.println(reverse);
        DoubleNode after = removeValue(reverse, 4);
        System.out.println(after);
    }

    /**
     * 双向链表反转
     *
     * @param head 双向链表头节点
     * @return 反转后的双向链表
     */
    public static DoubleNode reverse(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 删除指定元素
     *
     * @param head
     * @param value
     * @return
     */
    public static DoubleNode removeValue(DoubleNode head, int value) {
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        DoubleNode pre = head;
        DoubleNode cur = head;
        while (cur != null) {
            if (cur.value == value) {
                cur.pre = pre.pre;
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 数组生成双向链表
     *
     * @param arr 数组
     * @return 单向链表
     */
    public static DoubleNode arrayToDoubleNode(int[] arr) {
        if (arr == null) {
            return null;
        }
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode node = new DoubleNode(arr[i]);
            node.pre = tail;
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }

    @Override
    public String toString() {
        DoubleNode node = this;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }
        return Arrays.toString(list.toArray());
    }
}
