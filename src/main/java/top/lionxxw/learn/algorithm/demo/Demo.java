package top.lionxxw.learn.algorithm.demo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/10 17:20
 */
public class Demo {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // 7 -> 0 -> 8
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int c = 0;
        ListNode p = l1, q = l2, curr = dummyHead;
        while (p != null || q != null) {
            int sum = c + (p == null ? 0 : p.val) + (q == null ? 0 : q.val);
            c = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (c > 0){
            curr.next = new ListNode(c);
        }

        return dummyHead.next;
    }
}
