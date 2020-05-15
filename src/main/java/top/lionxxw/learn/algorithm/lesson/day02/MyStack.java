package top.lionxxw.learn.algorithm.lesson.day02;

import com.sun.xml.internal.bind.util.Which;

import java.util.Scanner;
import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * > 1) pop、 push、 getMin操作的时间复杂度都是O(1)。<br>
 * > 2)设计的栈类型可以使用现成的栈结构。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/14 21:04
 */
public class MyStack {
    // 数据栈
    private Stack<Integer> dataStack;
    // 最小值栈
    private Stack<Integer> minStack;

    public MyStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * 第一种设计:
     * dataStack 和 minStack 层级保持一致,每次都存放一个最小值的栈
     * @param value
     */
    /*public void push(int value) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(value);
        } else {
            this.minStack.push(Math.min(value, getMin()));
        }
        this.dataStack.push(value);
    }

    public int pop() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }*/

    /**
     * 第二种设计
     * dataStack push 数据时,当前值小于等于最小值,minStack再存入最小值
     *
     * @param value
     */
    public void push(int value) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(value);
        } else {
            int min = Math.min(value, getMin());
            if (value <= min) {
                this.minStack.push(min);
            }
        }
        this.dataStack.push(value);
    }

    public int pop() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Integer value = this.dataStack.pop();
        int min = this.getMin();
        // dataStack pop 数据时,当前值小于等于最小值,minStack才pop操作
        if (value <= min) {
            this.minStack.pop();
        }
        return value;
    }


    public int getMin() {
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("请输入命令:push|pop|min|quit");
            String command = scanner.next();
            switch (command) {
                case "push":
                    System.out.println("请输入push的值");
                    int num = scanner.nextInt();
                    myStack.push(num);
                    System.out.println("push成功");
                    break;
                case "pop":
                    int pop = myStack.pop();
                    System.out.println("pop出来的值:" + pop);
                    break;
                case "min":
                    int min = myStack.getMin();
                    System.out.println("当前栈的最小值:" + min);
                    break;
                case "quit":
                    flag = false;
                    System.out.println("退出程序");
                    break;
                default:
                    System.out.println("非法命令");
                    break;
            }
        }
    }
}
