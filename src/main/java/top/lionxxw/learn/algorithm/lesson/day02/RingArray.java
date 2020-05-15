package top.lionxxw.learn.algorithm.lesson.day02;

/**
 * 数组实现栈和队列
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/14 20:35
 */
public class RingArray {

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static class MyQueue {
        private int size;
        private int[] arr;
        private int pushIndex;
        private int popIndex;
        private final int limit;

        public MyQueue(int limit) {
            size = 0;
            pushIndex = 0;
            popIndex = 0;
            arr = new int[limit];
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("queue is full");
            }
            size++;
            arr[pushIndex] = value;
            pushIndex = nexIndex(pushIndex);
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            size--;
            int value = arr[popIndex];
            popIndex = nexIndex(popIndex);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回下个下标位置
         *
         * @param index 当前下标
         * @return 返回下个下标位置
         */
        private int nexIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }

    public static class MyStack {
        private int[] stack;
        private int top = 0;

        public MyStack(int size) {
            stack = new int[size];
        }

        public void push(int value) {
            if (top == stack.length) {
                throw new RuntimeException("stack is full");
            }
            stack[top++] = value;
        }

        public int pop() {
            if (top == 0) {
                throw new RuntimeException("stack is empty");
            }
            return stack[--top];
        }
    }
}
