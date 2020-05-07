package top.lionxxw.learn.algorithm.demo;

import java.util.Arrays;

/**
 * 斐波拉契数列
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/7 10:53
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        Fibonacci fibonacci = new Fibonacci();
        long start = System.currentTimeMillis();
        System.out.println(fibonacci.f(n));
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
        long start2 = System.currentTimeMillis();
        System.out.println(fibonacci.f2(n));
        long end2 = System.currentTimeMillis();
        System.out.println("耗时:" + (end2 - start2) + "ms");
        long start3 = System.currentTimeMillis();
        System.out.println(fibonacci.f3(n));
        long end3 = System.currentTimeMillis();
        System.out.println("耗时:" + (end3 - start3) + "ms");
    }

    /**
     * 递归实现
     * 缺点:存在重复计算的问题
     */
    public long f(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    /**
     * 自顶向下的备忘录法(还是递归)
     * 使用memo记录相同数字的计算结果
     */
    public long f2(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return f(n, memo);
    }

    public long f(int n, long[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n < 2) {
            memo[n] = n;
        } else {
            memo[n] = f(n - 1, memo) + f(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 自底向上的动态规划
     */
    public long f3(int n) {
        long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                memo[i] = i;
            } else {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
        }
        return memo[n];
    }
}
