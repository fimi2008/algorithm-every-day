package top.lionxxw.learn.algorithm.leetcode;

import java.util.*;

/**
 * 202 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author wangxiang
 * created on 2020/4/30 17:06
 */
public class Day03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入判断是否为快乐数的值:");
        int n = scanner.nextInt();
        Day03 demo = new Day03();
        System.out.println(demo.isHappy(n));
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
            System.out.println("下一个数:" + n);
        }
        return n == 1;
    }

    /**
     * 获取下一个数
     *
     * @param n 上一个数
     * @return 下一个数
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            System.out.println("d*d=" + d);
            sum += d * d;
        }
        return sum;
    }
}
