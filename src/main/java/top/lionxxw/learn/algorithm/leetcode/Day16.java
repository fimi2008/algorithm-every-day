package top.lionxxw.learn.algorithm.leetcode;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/12 18:24
 */
public class Day16 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }

    /**
     * 用单链表来定义栈
     */
    public static class MinStack {

        private Node head;

        /**
         * 链表节点定义
         */
        private static class Node {
            /**
             * 下一个节点
             */
            Node next;
            /**
             * 最小值
             */
            int min;
            /**
             * 元素值
             */
            int val;

            public Node(int val, int min) {
                this.min = min;
                this.val = val;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        public MinStack() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x, null);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
