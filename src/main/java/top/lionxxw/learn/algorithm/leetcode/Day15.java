package top.lionxxw.learn.algorithm.leetcode;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/11 18:45
 */
public class Day15 {
    public static void main(String[] args) {
        Day15 demo = new Day15();
        System.out.println(demo.myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return quickMul(x, n);
    }

    /**
     * 「快速幂算法」的本质是分治算法。
     * 当我们要计算 x^n 时，我们可以先递归地计算出 y = x^⌊n/2⌋
     * <p>
     * 根据递归计算的结果，如果 n 为偶数，那么 x^n = y^2x；如果 n 为奇数，那么 x^n = y^2 * x
     * f     *
     * 递归的边界为 n = 0，任意数的 0 次方均为 1。
     * 复杂度分析
     * <p>
     * 时间复杂度：O(logn)，即为递归的层数。
     * <p>
     * 空间复杂度：O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
     */
    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 快速幂 + 迭代
     * 由于递归需要使用额外的栈空间，我们试着将递归转写为迭代。
     * 复杂度分析
     * <p>
     * 时间复杂度：O(logn)，即为对 n 进行二进制拆分的时间复杂度。
     * <p>
     * 空间复杂度：O(1)。
     */
    private double quickMul2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double res = 1.0;
        // 贡献的初始值为 x
        double temp = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                res *= temp;
            }
            // 将贡献不断地平方
            temp *= temp;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return res;
    }
}
